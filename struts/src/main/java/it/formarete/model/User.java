package it.formarete.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 7599042086887426624L;

	private String username;
	private String password;
	private String fullname;

	public User() {
	}

	public User(String username, String password, String fullname) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
