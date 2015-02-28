package it.formarete.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Profile extends ActionSupport {
	private static final long serialVersionUID = -7118875989779608488L;

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null || session.getAttribute("login") == null) {
			return "login";
		}
		return "success";
	}
}
