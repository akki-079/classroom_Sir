package com.demo.spring.jwt.util;

public class JwtUser {
	private String username;
	private String password;

	public JwtUser() {

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
