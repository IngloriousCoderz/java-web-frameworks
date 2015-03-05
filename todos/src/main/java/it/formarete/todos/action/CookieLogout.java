package it.formarete.todos.action;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CookieLogout extends ActionSupport {
	private static final long serialVersionUID = 8501167563209849152L;

	@Override
	public String execute() throws Exception {
		for (Cookie cookie : ServletActionContext.getRequest().getCookies()) {
			if (cookie.getName().equals("user")) {
				cookie.setMaxAge(0);
				ServletActionContext.getResponse().addCookie(cookie);
			}
		}
		return SUCCESS;
	}
}
