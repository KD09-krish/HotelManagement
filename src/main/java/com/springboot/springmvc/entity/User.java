package com.springboot.springmvc.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {

	@NotEmpty
	@Email
	private String username;
	
	@NotEmpty
	private String password;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
