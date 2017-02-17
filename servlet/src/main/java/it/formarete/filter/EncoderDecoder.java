package it.formarete.filter;

import java.io.IOException;
import java.util.Base64;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncoderDecoder implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String token = (String) request.getAttribute("token");
		if (token != null) {
			String decoded = new String(Base64.getDecoder().decode(token.getBytes()));
			request.setAttribute("token", decoded);
		}

		chain.doFilter(request, response);

		token = (String) request.getAttribute("token");
		if (token != null) {
			String encoded = new String(Base64.getEncoder().encode(token.getBytes()));
			request.setAttribute("token", encoded);
		}
	}

	@Override
	public void destroy() {
	}
}
