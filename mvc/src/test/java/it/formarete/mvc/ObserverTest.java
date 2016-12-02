package it.formarete.mvc;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ObserverTest {

	private View view;

	@Before
	public void setUp() {
		view = new View();
	}

	@Test
	public void testViewInit() {
		assertEquals("<h1>Hello nobody!</h1>", view.getOutput());
	}

	@Test
	public void testPublish() {
		Model model = new Model();
		model.addObserver(view);
		model.setAttribute("world");
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
