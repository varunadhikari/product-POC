package com.product.service;

import java.util.ArrayList;
import java.util.Optional;

import com.product.entity.UserDetail;
import com.product.mapper.UserDetailMapper;
import com.product.mapper.UserMapper;
import com.product.model.AuthenticationRequest;
import com.product.model.UserDTO;
import com.product.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.product.entity.User;
import com.product.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserDetailRepository userDetailRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findById(username);
		return new org.springframework.security.core.userdetails.User(user.get().getId(), user.get().getPassword(), new ArrayList<>());
	}

	public UserDTO getUserDetails(AuthenticationRequest request){
		Optional<User> user = userRepository.findById(request.getUsername());
		UserDTO userResponse = new UserDTO();
		if(user.isPresent()){
			Optional<UserDetail> details = userDetailRepository.findById(user.get().getId());
			userResponse = UserMapper.INSTANCE.userToUserDTO(user.get());
			if(details.isPresent()){
				userResponse.setUserDetails(UserDetailMapper.INSTANCE.userDetailToUserDetailDTO(details.get()));
			}
		}
		return userResponse;
	}

    public UserDTO saveUser(UserDTO user) {
		User userEntity = UserMapper.INSTANCE.userDTOToUser(user);
		return UserMapper.INSTANCE.userToUserDTO(userRepository.save(userEntity));
    }
}
