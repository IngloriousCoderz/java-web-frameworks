package it.formarete.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class Authentication extends AbstractInterceptor {
	private static final long serialVersionUID = 5857937186540313938L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		String result = invocation.invoke();
		return result;
	}
}
