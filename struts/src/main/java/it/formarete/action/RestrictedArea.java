package it.formarete.action;

import it.formarete.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RestrictedArea extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1063416495504411616L;

	private User user;

	public RestrictedArea() {
		user = new User();
		user.setUsername("stronzo");
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	@Override
	public User getModel() {
		return user;
	}
}
