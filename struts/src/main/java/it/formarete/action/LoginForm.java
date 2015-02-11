package it.formarete.action;

import java.util.Map;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginForm extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 284613619823620755L;

	private Map<String, Object> request;
	private String message;
	private String destination;
	private String username;
	private String password;

	public String execute() {
		if (!username.isEmpty() || !password.isEmpty()) {
			message = "nome utente e password non corrispondono, riprova";
		}

		destination = ((ActionMapping) request.get("struts.actionMapping"))
				.getName();

		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
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

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
