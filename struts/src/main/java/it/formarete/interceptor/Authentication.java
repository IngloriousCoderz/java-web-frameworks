package it.formarete.interceptor;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Authentication extends AbstractInterceptor {
	private static final long serialVersionUID = 5857937186540313938L;

	private String username;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = null;

		user = UsersDB.get(username);

		if (user != null) {
			return invocation.invoke();
		}

		Map<String, Object> params = ActionContext.getContext().getParameters();

		String[] usernames = (String[]) params.get("username");
		String[] passwords = (String[]) params.get("password");

		if (usernames == null || passwords == null) {
			return Action.LOGIN;
		}

		user = UsersDB.get(usernames[0]);

		if (user != null) {
			if (user.getPassword().equals(passwords[0])) {
				Cookie cookie = new Cookie("username", usernames[0]);
				ServletActionContext.getResponse().addCookie(cookie);
				return invocation.invoke();
			}
		}

		return Action.INPUT;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
