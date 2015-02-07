package it.formarete.mvc;

import junit.framework.TestCase;

public class ObserverTest extends TestCase {
	private View view;

	public void setUp() {
		view = new View();
	}

	public void testViewInit() {
		assertEquals("<h1>Hello nobody!</h1>", view.getOutput());
	}

	public void testPublish() {
		Model model = new Model();
		model.addSubscriber(view);
		model.setAttribute("world");
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
