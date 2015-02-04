package it.formarete.filter;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.io.IOException;
import java.util.Map;

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
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		User user = null;

		Map<String, String> cookies = (Map<String, String>) request
				.getAttribute("cookies");
		String cookieValue = cookies.get("USER");
		// String cookieValue = getCookieValue(httpRequest, "USER");
		user = UsersDB.get(cookieValue);

		if (user != null) {
			request.setAttribute("user", user);
			chain.doFilter(request, response);
			return;
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user = UsersDB.get(username);

		if (user != null) {
			if (user.getPassword().equals(password)) {
				httpResponse.addCookie(new Cookie("USER", user.getUsername()));
				request.setAttribute("user", user);
				chain.doFilter(request, response);
				return;
			}
		}

		request.setAttribute("destination", httpRequest.getRequestURI());
		if (username != null || password != null) {
			request.setAttribute("message",
					"nome utente e password non corrispondono, riprova");
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	private String getCookieValue(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		String cookieValue = null;

		if (cookies == null) {
			return cookieValue;
		}

		int i = 0;
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
