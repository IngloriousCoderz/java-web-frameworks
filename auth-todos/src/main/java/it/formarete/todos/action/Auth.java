package it.formarete.todos.action;

import it.formarete.todos.model.User;
import it.formarete.todos.service.UsersDB;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class Auth extends ActionSupport implements ServletResponseAware {

	private static final long serialVersionUID = -6380365904086570517L;

	private String username;
	private String password;
	private HttpServletResponse response;

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
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public String execute() {
		if (username != null) {
			User user = UsersDB.getInstance().get(username);
			if (user != null && user.getPassword().equals(password)) {
				response.addCookie(new Cookie("token", "true"));
				return SUCCESS;
			}
			return INPUT;
		}

		return LOGIN;
	}

	public String logout() {
		Cookie cookie = new Cookie("token", "true");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return SUCCESS;
	}
}
