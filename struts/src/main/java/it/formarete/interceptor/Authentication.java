package it.formarete.interceptor;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.util.Map;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Authentication extends AbstractInterceptor implements
		StrutsStatics {
	private static final long serialVersionUID = 5857937186540313938L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		User user = null;

		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();
		User userInSession = (User) session.get("USER");
		if (userInSession != null) {
			user = UsersDB.get(userInSession.getUsername());
		}

		if (user != null) {
			return invocation.invoke();
		}

		return Action.LOGIN;
	}
}
