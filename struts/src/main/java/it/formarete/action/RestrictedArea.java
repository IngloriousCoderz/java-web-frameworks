package it.formarete.action;

import it.formarete.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RestrictedArea extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1063416495504411616L;

	private String USER;
	private User user;

	public RestrictedArea() {
		user = new User();
		user.setUsername("nobody");
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return user;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String USER) {
		this.USER = USER;
	}
}
