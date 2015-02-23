package it.formarete.test;

import it.formarete.action.Login;

import java.util.HashMap;

import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;

public class LoginTestCase extends TestCase {
	private Login login;

	public void setUp() {
		login = new Login();
		login.setCookiesMap(new HashMap<String, String>());
	}

	public void testAlreadyLoggedIn() throws Exception {
		login.getCookiesMap().put("USER", "giancarlo");
		assertEquals(Action.SUCCESS, login.execute());
	}

	public void testNoLoginAttempts() throws Exception {
		assertEquals(Action.INPUT, login.execute());
	}

	public void testSuccessfulLogin() throws Exception {
		login.setUsername("giancarlo");
		login.setPassword("magalli");
		assertEquals(Action.SUCCESS, login.execute());
	}

	public void testWrongUsername() throws Exception {
		login.setUsername("pippo");
		login.setPassword("baudo");
		assertEquals(Action.LOGIN, login.execute());
	}

	public void testWrongPassword() throws Exception {
		login.setUsername("giancarlo");
		login.setPassword("nonparlo");
		assertEquals(Action.LOGIN, login.execute());
	}

	public void testLogout() throws Exception {
		login.getCookiesMap().put("USER", "giancarlo");
		assertEquals("giancarlo", login.getCookiesMap().get("USER"));
		assertTrue(login.getCookies().size() > 0);

		assertEquals(Action.SUCCESS, login.logout());
		assertNull(login.getCookiesMap().get("USER"));
		assertTrue(login.getCookies().size() == 0);
	}
}
