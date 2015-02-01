package it.formarete.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Authentication implements Filter {
	private final static String USERNAME = "username";
	private final static String PASSWORD = "password";

	private String rightUsername;
	private String rightPassword;

	@Override
	public void init(FilterConfig config) throws ServletException {
		rightUsername = config.getInitParameter(USERNAME);
		rightPassword = config.getInitParameter(PASSWORD);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String cookieValue = getCookieValue(httpRequest, USERNAME);

		if (rightUsername.equals(cookieValue)) {
			chain.doFilter(request, response);
			return;
		}

		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);

		if (rightUsername.equals(username) && rightPassword.equals(password)) {
			httpResponse.addCookie(new Cookie(USERNAME, username));
			chain.doFilter(request, response);
			return;
		}

		request.setAttribute("message",
				"nome utente e password non corrispondono, riprova");
		request.setAttribute("destination", httpRequest.getRequestURI());
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	private String getCookieValue(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		int i = 0;
		String cookieValue = null;
		while (i < cookies.length && cookieValue == null) {
			Cookie cookie = cookies[i];
			if (name.equals(cookie.getName())) {
				cookieValue = cookie.getValue();
			}
			i++;
		}
		return cookieValue;
	}

	@Override
	public void destroy() {
	}
}
