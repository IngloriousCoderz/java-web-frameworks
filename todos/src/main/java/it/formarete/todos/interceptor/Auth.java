package it.formarete.todos.interceptor;

import it.formarete.todos.model.User;
import it.formarete.todos.service.UsersDB;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class Auth extends AbstractInterceptor {
	private static final long serialVersionUID = -1101281231596857880L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		for (Cookie cookie : ServletActionContext.getRequest().getCookies()) {
			if (cookie.getName().equals("login")) {
				return invocation.invoke();
			}
		}

		ValueStack stack = invocation.getStack();
		String username = stack.findString("username");
		String password = stack.findString("password");

		if (username != null) {
			User user = UsersDB.getInstance().get(username);
			if (user != null && user.getPassword().equals(password)) {
				ServletActionContext.getResponse().addCookie(
						new Cookie("login", "true"));
				return invocation.invoke();
			}
			return Action.INPUT;
		}

		return Action.LOGIN;
	}
}
