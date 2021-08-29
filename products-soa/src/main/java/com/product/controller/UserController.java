package com.product.controller;

import com.product.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.AuthenticationRequest;
import com.product.service.UserService;
import com.product.util.JwtUtil;

@RestController
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserService userDetailsService;

	@GetMapping("/hello" )
	public String firstPage() {
		return "Hello World";
	}

	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(jwt);
	}

	@PostMapping("/user")
	public ResponseEntity<UserDTO> getUserDetails(@RequestBody AuthenticationRequest authenticationRequest) {
		UserDTO response = userDetailsService.getUserDetails(authenticationRequest);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/user/save")
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO user) {
		UserDTO response = userDetailsService.saveUser(user);
		return ResponseEntity.ok(response);
	}

}
