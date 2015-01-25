package struts;

import it.formarete.HelloWorldActionWithActionSupport;
import junit.framework.TestCase;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldWithActionSupportTestCase extends TestCase {
	public void testName() {
		HelloWorldActionWithActionSupport action = new HelloWorldActionWithActionSupport();
		action.setName("Antony");
		assertEquals("Antony", action.getName());
	}

	public void testExecute() throws Exception {
		HelloWorldActionWithActionSupport action = new HelloWorldActionWithActionSupport();
		action.setName("SECRET");
		assertEquals(ActionSupport.SUCCESS, action.execute());

		action.setName("PUBLIC");
		assertEquals(ActionSupport.ERROR, action.execute());
	}
}
