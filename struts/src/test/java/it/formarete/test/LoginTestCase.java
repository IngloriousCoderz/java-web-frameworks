package it.formarete.test;

import it.formarete.action.Auth;
import junit.framework.TestCase;

import com.opensymphony.xwork2.Action;

public class LoginTestCase extends TestCase {
	private Auth auth;

	public void setUp() {
		auth = new Auth();
	}

	public void testAlreadyLoggedIn() throws Exception {
		auth.setLogin("true");
		assertEquals(Action.SUCCESS, auth.execute());
	}

	public void testNoLoginAttempts() throws Exception {
		assertEquals(Action.LOGIN, auth.execute());
	}

	public void testWrongUsername() throws Exception {
		auth.setUsername("pippo");
		auth.setPassword("baudo");
		assertEquals(Action.INPUT, auth.execute());
	}

	public void testWrongPassword() throws Exception {
		auth.setUsername("giancarlo");
		auth.setPassword("nonparlo");
		assertEquals(Action.INPUT, auth.execute());
	}

	public void testSuccessfulLogin() throws Exception {
		auth.setUsername("giancarlo");
		auth.setPassword("magalli");
		assertEquals(Action.SUCCESS, auth.execute());
	}

	public void testLogout() throws Exception {
		auth.setLogin("true");
		assertEquals("giancarlo", auth.getLogin());
		assertFalse(auth.getCookies().isEmpty());

		assertEquals(Action.SUCCESS, auth.logout());
		assertNull(auth.getLogin());
		assertTrue(auth.getCookies().isEmpty());
	}
}
