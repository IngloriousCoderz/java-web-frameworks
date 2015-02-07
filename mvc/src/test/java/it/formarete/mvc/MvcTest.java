package it.formarete.mvc;

import junit.framework.TestCase;

public class MvcTest extends TestCase {
	private Model model;
	private View view;
	private Controller controller;

	public void setUp() {
		model = new Model();
		view = new View();
		controller = new Controller();
		controller.setModel(model);
	}

	public void testUpdateFromController() {
		controller.setView(view);

		controller.handleInput("world");
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello nobody!</h1>", view.getOutput());

		controller.updateView(model.getAttribute());
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}

	public void testUpdateFromModel() {
		model.addSubscriber(view);

		controller.handleInput("world");
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
