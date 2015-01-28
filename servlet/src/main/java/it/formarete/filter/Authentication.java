package it.formarete.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Authentication implements Filter {
	private String rightUsername;
	private String rightPassword;

	public void init(FilterConfig config) throws ServletException {
		rightUsername = config.getInitParameter("username");
		rightPassword = config.getInitParameter("password");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (rightUsername.equals(username) && rightPassword.equals(password)) {
			request.setAttribute("username", username);
			chain.doFilter(request, response);
		} else {
			if (username != null && password != null) {
				request.setAttribute("message",
						"nome utente e password non corrispondono, riprova");
			}
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			request.setAttribute("destination", httpRequest.getRequestURI());
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void destroy() {
	}
}
