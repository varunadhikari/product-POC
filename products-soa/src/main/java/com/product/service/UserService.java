package com.product.service;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.util.CollectionUtils;

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
			userResponse = UserMapper.INSTANCE.userToUserDTO(user.get());
			if(user.get().getUserDetails() != null){
				userResponse.setUserDetails(UserDetailMapper.INSTANCE.userDetailToUserDetailDTO(user.get().getUserDetails()));
			}
		}
		return userResponse;
	}

    public UserDTO saveUser(UserDTO user) {
		User userEntity = UserMapper.INSTANCE.userDTOToUser(user);
		userEntity.setUserDetails(UserDetailMapper.INSTANCE.userDetailDTOToUserDetail(user.getUserDetails()));
		userEntity.getUserDetails().setUser(userEntity);
		User respEntity = userRepository.saveAndFlush(userEntity);
		UserDTO userResponseDTO = UserMapper.INSTANCE.userToUserDTO(respEntity);
		userResponseDTO.setUserDetails(UserDetailMapper.INSTANCE.userDetailToUserDetailDTO(respEntity.getUserDetails()));
		return userResponseDTO;
    }

    public UserDTO getUserById(String id) {
		Optional<User> user = userRepository.findById(id);
		UserDTO userResponseDTO = UserMapper.INSTANCE.userToUserDTO(user.get());
		userResponseDTO.setUserDetails(UserDetailMapper.INSTANCE.userDetailToUserDetailDTO(user.get().getUserDetails()));
		return userResponseDTO;
    }

	public List<UserDTO> getUserDetailList() {
		List<User> users = userRepository.findAll();
		List<UserDTO> userRespList = UserMapper.INSTANCE.userListToUserDTO(users);

		return userRespList;
	}
}
