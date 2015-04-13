package it.formarete.feisbuc.interceptor;

import it.formarete.feisbuc.model.User;
import it.formarete.feisbuc.service.UserDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Auth extends AbstractInterceptor {
	private static final long serialVersionUID = -1101281231596857880L;

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("login")) {
					return invocation.invoke();
				}
			}
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username != null) {
			User user = userDao.get(username);
			if (user != null && user.getPassword().equals(password)) {
				response.addCookie(new Cookie("login", username));
				invocation.getStack().setValue("username", username);
				return invocation.invoke();
			}
			return Action.INPUT;
		}

		return Action.LOGIN;
	}
}
