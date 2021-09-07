package com.product.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USER_ID")
	private String id;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;

	@OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private UserDetail userDetails;

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

	public UserDetail getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetail userDetails) {
		this.userDetails = userDetails;
	}
}
