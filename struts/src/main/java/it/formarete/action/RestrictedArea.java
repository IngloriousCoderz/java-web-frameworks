package it.formarete.action;

import com.opensymphony.xwork2.ActionSupport;

public class RestrictedArea extends ActionSupport {
	private static final long serialVersionUID = 1063416495504411616L;

	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		if ("giancarlo".equals(username) && "magalli".equals(password)) {
			return SUCCESS;
		}
		return LOGIN;
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
