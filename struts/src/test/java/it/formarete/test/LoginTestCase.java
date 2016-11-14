package it.formarete.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.opensymphony.xwork2.Action;

import it.formarete.action.Auth;
import it.formarete.exception.InputException;
import it.formarete.exception.LoginException;

public class LoginTestCase {

    private Auth auth;

    @Before
    public void setUp() {
        auth = new Auth();
    }

    @Test
    public void testAlreadyLoggedIn() throws Exception {
        auth.setToken("giancarlo");
        auth.prepare();
    }

    @Test(expected = LoginException.class)
    public void testNoLoginAttempts() throws Exception {
        auth.prepare();
    }

    @Test(expected = InputException.class)
    public void testWrongUsername() throws Exception {
        auth.setUsername("pippo");
        auth.setPassword("baudo");
        auth.prepare();
    }

    @Test(expected = InputException.class)
    public void testWrongPassword() throws Exception {
        auth.setUsername("giancarlo");
        auth.setPassword("nonparlo");
        auth.prepare();
    }

    @Test
    public void testSuccessfulLogin() throws Exception {
        auth.setUsername("giancarlo");
        auth.setPassword("magalli");
        auth.prepare();
    }

    @Test
    public void testLogout() throws Exception {
        auth.setToken("giancarlo");
        assertFalse(auth.getCookies().isEmpty());

        assertEquals(Action.SUCCESS, auth.logout());
        assertFalse(auth.getCookies().isEmpty());
    }
}
