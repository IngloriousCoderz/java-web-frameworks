package it.formarete.mvc.inheritance;

import it.formarete.mvc.Observable;
import it.formarete.mvc.Model;

public class ObservableModel extends Observable implements Model {

	private String attribute;

	@Override
	public String getAttribute() {
		return attribute;
	}

	@Override
	public void setAttribute(String attribute) {
		this.attribute = attribute;
		publish(attribute);
	}
}
