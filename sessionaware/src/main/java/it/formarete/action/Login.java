package it.formarete.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class Login implements SessionAware {
	private String name;
	private String password;
	private SessionMap<String, Object> session;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

	public String execute() {
		if ("admin".equals(name) && "admin".equals(password)) {
			session.put("login", "true");
			session.put("name", name);
			return "success";
		}
		return "login";
	}

	public String logout() {
		if (session != null) {
			session.invalidate();
		}
		return "success";
	}
}
