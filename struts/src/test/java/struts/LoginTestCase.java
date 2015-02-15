package struts;

import it.formarete.action.Login;
import junit.framework.TestCase;

import com.opensymphony.xwork2.ActionSupport;

public class LoginTestCase extends TestCase {
	public void testSuccessfulLogin() throws Exception {
		Login login = new Login();
		login.setUsername("giancarlo");
		login.setPassword("magalli");
		assertEquals(ActionSupport.SUCCESS, login.execute());
	}

	public void testFailedLogin() throws Exception {
		Login login = new Login();
		login.setUsername("pippo");
		login.setPassword("baudo");
		assertEquals(ActionSupport.LOGIN, login.execute());
	}
}
