package it.formarete.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieMap implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		Map<String, String> cookies = new HashMap<String, String>();
		for (Cookie cookie : httpRequest.getCookies()) {
			cookies.put(cookie.getName(), cookie.getValue());
		}
		request.setAttribute("cookies", cookies);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
