package com.product.model;

import java.util.List;

public class UserDTO {

	private String id;
	private String password;
	private String role;
	private UserDetailDTO userDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public UserDetailDTO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailDTO userDetails) {
		this.userDetails = userDetails;
	}
	
}
