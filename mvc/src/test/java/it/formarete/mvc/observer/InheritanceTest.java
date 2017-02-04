package it.formarete.mvc.observer;

import it.formarete.mvc.View;
import it.formarete.mvc.inheritance.ObservableModel;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InheritanceTest {

	@Test
	public void testObserver() {
		ObservableModel model = new ObservableModel();
		View view = new View();
		model.addObserver(view);

		model.setAttribute("world");
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
