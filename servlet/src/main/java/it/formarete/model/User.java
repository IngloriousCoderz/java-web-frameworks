package it.formarete.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 7599042086887426624L;

	private String username;
	private String password;

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
