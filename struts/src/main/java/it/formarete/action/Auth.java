package it.formarete.action;

import it.formarete.exception.InputException;
import it.formarete.exception.LoginException;
import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;

import org.apache.struts2.interceptor.CookieProvider;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class Auth extends ActionSupport implements Preparable, CookieProvider {

	private static final long serialVersionUID = 1063416495504411616L;

	private String token;
	private String username;
	private String password;
	private User user;

	public void setToken(String token) {
		this.token = token;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	@Override
	public Set<Cookie> getCookies() {
		Set<Cookie> cookies = new HashSet<Cookie>();
		Cookie cookie = new Cookie("token", token);
		cookies.add(cookie);
		return cookies;
	}

	@Override
	public void validate() {
		if (username == null) {
			addFieldError("username", "No username provided");
		}

		if (password == null) {
			addFieldError("password", "No password provided");
		}
	}

	@Override
	public void prepare() {
		if (token != null) {
			user = UsersDB.getInstance().get(token);
			return;
		}

		if (username == null) {
			throw new LoginException();
		}

		user = UsersDB.getInstance().get(username);
		if (user == null || !user.getPassword().equals(password)) {
			throw new InputException();
		}

		token = username;
	}

	public String logout() throws Exception {
		token = null;
		return SUCCESS;
	}
}
