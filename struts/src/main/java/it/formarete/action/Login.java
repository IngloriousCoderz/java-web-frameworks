package it.formarete.action;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	private static final long serialVersionUID = -2195611022007498025L;

	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		User user = UsersDB.get(username);

		if (user != null && user.getPassword().equals(password)) {
			return SUCCESS;
		}

		if (username != null || password != null) {
			return LOGIN;
		}

		return INPUT;
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
