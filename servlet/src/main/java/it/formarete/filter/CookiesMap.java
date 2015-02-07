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
import javax.servlet.http.HttpServletResponse;

public class CookiesMap implements Filter {
	String[] cookieNames;

	@Override
	public void init(FilterConfig config) throws ServletException {
		String initParam = config.getInitParameter("cookieNames");
		if (initParam != null) {
			cookieNames = initParam.split(",");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Map<String, String> cookiesMap = new HashMap<String, String>();

		Cookie[] cookies = httpRequest.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookiesMap.put(cookie.getName(), cookie.getValue());
			}
		}

		if (cookieNames == null) {
			cookieNames = (String[]) cookiesMap.keySet().toArray();
		}

		for (String cookieName : cookieNames) {
			request.setAttribute(cookieName, cookiesMap.get(cookieName));
		}

		chain.doFilter(request, response);

		for (String cookieName : cookieNames) {
			if (cookiesMap.get(cookieName) == null) {
				String cookieValue = (String) request.getAttribute(cookieName);
				// a null cookie is ok
				httpResponse.addCookie(new Cookie(cookieName, cookieValue));
			}
		}
	}

	@Override
	public void destroy() {
	}
}
