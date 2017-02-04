package it.formarete.mvc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ViewTest {

	@Test
	public void testInit() {
		View view = new View();
		assertEquals("<h1>Hello nobody!</h1>", view.getOutput());
	}

	@Test
	public void testUpdate() {
		View view = new View();
		view.update("world");
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
