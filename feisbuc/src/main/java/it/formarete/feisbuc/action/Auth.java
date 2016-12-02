package it.formarete.feisbuc.action;

import it.formarete.feisbuc.model.User;
import it.formarete.feisbuc.service.UserDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class Auth extends ActionSupport implements ServletRequestAware,
				ServletResponseAware {

	private static final long serialVersionUID = -6380365904086570517L;

	private UserDao userDao;
	private User user;
	private String username;
	private String password;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public String execute() {
		if (username != null) {
			user = userDao.get(username);
			if (user != null && user.getPassword().equals(password)) {
				return login();
			}
			return INPUT;
		}

		return LOGIN;
	}

	public String register() {
		user.setName(username);
		user.setPassword(password);
		try {
			userDao.save(user);
		} catch (Exception e) {
			return ERROR;
		}
		return login();
	}

	public String login() {
		response.addCookie(new Cookie("uuid", "" + user.getId()));
		return SUCCESS;
	}

	public String logout() {
		Cookie cookie = new Cookie("uuid", "" + user.getId());
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return SUCCESS;
	}

	public String unregisterConfirm() {
		return "confirm";
	}

	public String unregister() {
		Integer id = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("uuid")) {
					id = Integer.parseInt(cookie.getValue());
				}
			}
		}
		userDao.delete(id);
		return logout();
	}
}
