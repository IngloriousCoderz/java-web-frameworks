package it.formarete.todos.interceptor;

import it.formarete.todos.model.User;
import it.formarete.todos.service.UsersDB;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Auth extends AbstractInterceptor {
	private static final long serialVersionUID = -1101281231596857880L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login")) {
					return invocation.invoke();
				}
			}
		}

		/*
		 * solution 1: get values from stack but every Action complains about
		 * missing username and password setters.
		 */
		// ValueStack stack = invocation.getStack();
		// String username = stack.findString("username");
		// String password = stack.findString("password");

		/* solution 2: try to use Struts but deal with parameters as String arrays. */
		// Map<String, Object> params = invocation.getInvocationContext()
		// .getParameters();
		// String[] usernames = (String[]) params.get("username");
		// String[] passwords = (String[]) params.get("password");
		// if (usernames == null || passwords == null) {
		// return Action.LOGIN;
		// }
		// String username = usernames[0];
		// String password = passwords[0];

		/* solution 3: cul8r Struts */
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

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
