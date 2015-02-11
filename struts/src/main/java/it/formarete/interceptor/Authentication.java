package it.formarete.interceptor;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class Authentication extends AbstractInterceptor {
	private static final long serialVersionUID = 5857937186540313938L;

	private static final Logger LOG = LoggerFactory
			.getLogger(Authentication.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = null;

		ValueStack stack = invocation.getStack();
		String USER = stack.findString("USER");
		String username = stack.findString("username");
		String password = stack.findString("password");
		LOG.info("USER: [#0], username: [#1], password: [#2]", USER, username,
				password);

		user = UsersDB.get(USER);

		if (user != null) {
			stack.set("user", user);
			return invocation.invoke();
		}

		user = UsersDB.get(username);

		if (user != null && user.getPassword().equals(password)) {
			ServletActionContext.getResponse()
					.addCookie(new Cookie("USER", username));
			stack.set("user", user);
			return invocation.invoke();
		}

		return Action.LOGIN;
	}
}
