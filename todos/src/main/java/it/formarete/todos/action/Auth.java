package it.formarete.todos.action;

import it.formarete.todos.model.User;
import it.formarete.todos.service.UsersDB;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Auth extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -6380365904086570517L;

	private SessionMap<String, Object> session;
	private String username;
	private String password;

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

	@Override
	public String execute() {
		UsersDB db = UsersDB.getInstance();

		String whoami = (String) session.get("user");
		if (whoami != null) {
			User user = db.get(whoami);
			if (user != null) {
				return SUCCESS;
			}
		}

		if (username != null) {
			User user = db.get(username);
			if (user != null && user.getPassword().equals(password)) {
				session.put("user", user.getName());
				return SUCCESS;
			}
			return INPUT;
		}

		return LOGIN;
	}

	public String logout() {
		session.invalidate();
		return SUCCESS;
	}
}
