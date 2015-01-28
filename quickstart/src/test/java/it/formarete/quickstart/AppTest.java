package it.formarete.quickstart;

import junit.framework.TestCase;

public class AppTest extends TestCase {
	public void testAppName() {
		App app = new App();
		app.setName("quickstart");
		assertEquals("quickstart", app.getName());
	}
}
