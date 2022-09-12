package com.demo.web.util;

public class Authenticator {
	private String username;
	private String password;
	private boolean loggedIn;

	public Authenticator() {

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

	public boolean isLoggedIn() {
		if (username.equals(password)) {
			this.loggedIn = true;
		} else {
			this.loggedIn = false;
		}
		return this.loggedIn;
	}

}
