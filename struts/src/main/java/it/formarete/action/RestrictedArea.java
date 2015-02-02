package it.formarete.action;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RestrictedArea extends ActionSupport implements SessionAware, ModelDriven<User> {
	private static final long serialVersionUID = 1063416495504411616L;

	private Map<String, Object> session;
	private User user = new User();

	@Override
	public String execute() throws Exception {
		String username = user.getUsername();
		String password = user.getPassword();
		User authUser = UsersDB.get(username);

		if (authUser != null) {
			if (authUser.getPassword().equals(password)) {
				session.put("USER", user);
				return SUCCESS;
			}
		}

		return INPUT;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public User getModel() {
		return user;
	}
}
