package it.formarete.mvc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MvcTest {
	private Model model;
	private View view;
	private Controller controller;

	@Before
	public void setUp() {
		model = new Model();
		view = new View();
		controller = new Controller();
		controller.setModel(model);
	}

	@Test
	public void testUpdateFromController() {
		controller.setView(view);

		boolean updateView = true;
		controller.handleInput("world", updateView);
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}

	@Test
	public void testUpdateFromModel() {
		model.addObserver(view);

		boolean updateView = false;
		controller.handleInput("world", updateView);
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
