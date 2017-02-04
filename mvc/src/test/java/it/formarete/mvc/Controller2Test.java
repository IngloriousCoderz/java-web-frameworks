package it.formarete.mvc;

import it.formarete.mvc.inheritance.ObservableModel;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Controller2Test {

	@Test
	public void testHandleInput() {
		ObservableModel model = new ObservableModel();
		View view = new View();
		model.addObserver(view);
		Controller2 controller = new Controller2();
		controller.setModel(model);

		controller.handleInput("world");
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
