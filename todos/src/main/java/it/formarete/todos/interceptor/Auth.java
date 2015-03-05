package it.formarete.todos.interceptor;

import it.formarete.todos.model.User;
import it.formarete.todos.service.UsersDB;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Auth extends AbstractInterceptor {
	private static final long serialVersionUID = 8828681928206151678L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();
		UsersDB db = UsersDB.getInstance();

		String whoami = (String) session.get("user");
		if (whoami != null) {
			User user = db.get(whoami);
			if (user != null) {
				return invocation.invoke();
			}
		}

		Map<String, Object> params = invocation.getInvocationContext()
				.getParameters();
		String[] usernames = (String[]) params.get("username");
		String[] passwords = (String[]) params.get("password");
		if (usernames == null && passwords == null) {
			return Action.LOGIN;
		}

		String username = usernames[0];
		String password = passwords[0];

		if (username != null) {
			User user = db.get(username);
			if (user != null && user.getPassword().equals(password)) {
				session.put("user", user.getName());
				return Action.SUCCESS;
			}
			return Action.INPUT;
		}

		return Action.LOGIN;
	}
}
