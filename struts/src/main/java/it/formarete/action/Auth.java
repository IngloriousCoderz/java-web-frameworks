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

	private String login;
	private String username;
	private String password;
	private User user;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Set<Cookie> getCookies() {
		Set<Cookie> cookies = new HashSet<Cookie>();
		//if (login != null) {
			Cookie cookie = new Cookie("login", login);
			cookies.add(cookie);
		//}
		return cookies;
	}

	@Override
	public void prepare() {
		if (login == null) {
			if (username == null) {
				throw new LoginException();
			}

			user = UsersDB.getInstance().get(username);
			if (user == null || !user.getPassword().equals(password)) {
				throw new InputException();
			}

			login = username;
		} else {
			user = UsersDB.getInstance().get(login);
		}
	}

	public String logout() throws Exception {
		login = null;
		return SUCCESS;
	}
}
