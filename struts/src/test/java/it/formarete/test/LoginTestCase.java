package it.formarete.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.opensymphony.xwork2.Action;

import it.formarete.action.Auth;

public class LoginTestCase {
	private Auth auth;

	@Before
	public void setUp() {
		auth = new Auth();
	}

	@Test
	public void testAlreadyLoggedIn() throws Exception {
		auth.setLogin("giancarlo");
		assertEquals(Action.SUCCESS, auth.execute());
	}

	@Test
	public void testNoLoginAttempts() throws Exception {
		assertEquals(Action.LOGIN, auth.execute());
	}

	@Test
	public void testWrongUsername() throws Exception {
		auth.setUsername("pippo");
		auth.setPassword("baudo");
		assertEquals(Action.INPUT, auth.execute());
	}

	@Test
	public void testWrongPassword() throws Exception {
		auth.setUsername("giancarlo");
		auth.setPassword("nonparlo");
		assertEquals(Action.INPUT, auth.execute());
	}

	@Test
	public void testSuccessfulLogin() throws Exception {
		auth.setUsername("giancarlo");
		auth.setPassword("magalli");
		assertEquals(Action.SUCCESS, auth.execute());
	}

	@Test
	public void testLogout() throws Exception {
		auth.setLogin("giancarlo");
		assertEquals("giancarlo", auth.getLogin());
		assertFalse(auth.getCookies().isEmpty());

		assertEquals(Action.SUCCESS, auth.logout());
		assertNull(auth.getLogin());
		assertTrue(auth.getCookies().isEmpty());
	}
}
