package it.formarete.mvc.observer;

import it.formarete.mvc.SimpleModel;
import it.formarete.mvc.View;
import it.formarete.mvc.decorator.ObservableDecorator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DecoratorTest {

	@Test
	public void testObserver() {
		ObservableDecorator model = new ObservableDecorator(new SimpleModel());
		View view = new View();
		model.addObserver(view);

		model.setAttribute("world");
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
