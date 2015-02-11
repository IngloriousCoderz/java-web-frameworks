package it.formarete.action;

import it.formarete.model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class RestrictedArea extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1063416495504411616L;

	private static final Logger LOG = LoggerFactory
			.getLogger(RestrictedArea.class);

	private String USER;
	private User user;

	@Override
	public String execute() throws Exception {
		user = (User) ActionContext.getContext().getValueStack().findValue("user");
		LOG.info("user: (#0, #1)", user.getUsername(), user.getPassword());
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
