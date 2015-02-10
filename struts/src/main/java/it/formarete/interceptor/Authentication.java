package it.formarete.interceptor;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Authentication extends AbstractInterceptor {
	private static final long serialVersionUID = 5857937186540313938L;

	private String USER;
	private String username;
	private String password;
	private String destination;
	private String message;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		destination = invocation.getInvocationContext().getName();
		User user = null;

		user = UsersDB.get(USER);

		if (user != null) {
			return invocation.invoke();
		}

		//username = "giancarlo";
		//password = "magalli";
		user = UsersDB.get(username);

		if (user != null && user.getPassword().equals(password)) {
			ServletActionContext.getResponse()
					.addCookie(new Cookie("USER", username));
			return invocation.invoke();
		}

		if (username != null || password != null) {
			message = "nome utente e password non corrispondono, riprova";
			return Action.INPUT;
		}

		return Action.LOGIN;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String USER) {
		this.USER = USER;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
