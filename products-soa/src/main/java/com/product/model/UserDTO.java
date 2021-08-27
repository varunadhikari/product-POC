package com.product.model;

import java.util.List;

public class UserDTO {

	private Integer id;
	private String password;
	private String role;
	private List<UserDetailDTO> userDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<UserDetailDTO> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetailDTO> userDetails) {
		this.userDetails = userDetails;
	}
	
}
