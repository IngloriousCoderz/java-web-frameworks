package it.formarete.action;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;

import org.apache.struts2.interceptor.CookieProvider;
import org.apache.struts2.interceptor.CookiesAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class Login extends ActionSupport implements CookiesAware,
		CookieProvider {
	private static final long serialVersionUID = 1063416495504411616L;

	private static final Logger LOG = LoggerFactory.getLogger(Login.class);

	private String username;
	private String password;
	private User user;

	private String USER;
	private Map<String, String> session;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String uSER) {
		USER = uSER;
	}

	/* used for testing */
	public Map<String, String> getCookiesMap() {
		return session;
	}

	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		this.session = cookies;
	}

	@Override
	public Set<Cookie> getCookies() {
		Set<Cookie> cookies = new HashSet<Cookie>();
		for (String key : session.keySet()) {
			cookies.add(new Cookie(key, session.get(key)));
		}
		return cookies;
	}

	@Override
	public String execute() throws Exception {
		String USER = session.get("USER");

		LOG.info("USER: #0, username: #1, password: #2", USER, username, password);

		user = UsersDB.get(USER);
		if (user != null) {
			return SUCCESS;
		}

		if (username == null && password == null) {
			return INPUT;
		}

		user = UsersDB.get(username);
		if (user == null) {
			return LOGIN;
		}

		if (user.getPassword().equals(password)) {
			session.put("USER", user.getUsername());
			return SUCCESS;
		}

		return LOGIN;
	}

	public String logout() throws Exception {
		session.remove("USER");
		return SUCCESS;
	}
}
