package it.formarete.action;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login2 extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = -2195611022007498025L;

	private Map<String, Object> request;
	private String message;
	private String destination;
	private String username;
	private String password;

	@Override
	public String execute() throws Exception {
		destination = ((ActionMapping) request.get("struts.actionMapping"))
				.getName();

//		User user = UsersDB.get(username);
//
//		if (user != null && user.getPassword().equals(password)) {
//			ServletActionContext.getResponse()
//					.addCookie(new Cookie("USER", username));
//			return SUCCESS;
//		}
//
//		if (username != null || password != null) {
//			return LOGIN;
//		}
//
//		return INPUT;
		return SUCCESS;
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

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
