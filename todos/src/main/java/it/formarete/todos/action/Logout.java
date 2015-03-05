package it.formarete.todos.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 8501167563209849152L;

	private SessionMap<String, Object> session;

	@Override
	public String execute() throws Exception {
		session.invalidate();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}
}
