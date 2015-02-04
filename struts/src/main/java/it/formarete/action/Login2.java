package it.formarete.action;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Login2 extends ActionSupport {
	private static final long serialVersionUID = -2195611022007498025L;

	private String message;
	private String destination;
	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		User user = UsersDB.get(username);

		if (user != null) {
			if (user.getPassword().equals(password)) {
				Cookie cookie = new Cookie("username", username);
				ServletActionContext.getResponse().addCookie(cookie);
				return SUCCESS;
			}
		}

		message = "nome utente e password non corrispondono, riprova";
		destination = "home";

		return INPUT;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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
