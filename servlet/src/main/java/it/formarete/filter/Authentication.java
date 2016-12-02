package it.formarete.filter;

import it.formarete.model.User;
import it.formarete.service.UsersDB;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Authentication implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
					FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		User user = null;

		String username = (String) request.getAttribute("username");
		user = UsersDB.get(username);

		if (user != null) {
			request.setAttribute("user", user);
			chain.doFilter(request, response);
			return;
		}

		username = request.getParameter("username");
		user = UsersDB.get(username);

		String password = request.getParameter("password");
		if (user != null && user.getPassword().equals(password)) {
			request.setAttribute("username", user.getUsername());
			request.setAttribute("user", user);
			chain.doFilter(request, response);
			return;
		}

		request.setAttribute("destination", httpRequest.getRequestURI());
		if (username != null || password != null) {
			request.setAttribute("message",
							"nome utente e password non corrispondono, riprova");
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	public void destroy() {
	}
}
