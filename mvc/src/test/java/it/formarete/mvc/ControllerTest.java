package it.formarete.mvc;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ControllerTest {

	@Test
	public void testHandleInput() {
		SimpleModel model = new SimpleModel();
		View view = new View();
		Controller controller = new Controller();
		controller.setModel(model);
		controller.setView(view);

		controller.handleInput("world");
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
