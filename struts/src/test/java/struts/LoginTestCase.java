package struts;

import it.formarete.HelloWorldAction;
import junit.framework.TestCase;

public class HelloWorldTestCase extends TestCase {
	public void testName() {
		HelloWorldAction action = new HelloWorldAction();
		action.setName("Antony");
		assertEquals("Antony", action.getName());
	}

	public void testExecute() throws Exception {
		HelloWorldAction action = new HelloWorldAction();
		assertEquals("success", action.execute());
	}
}
