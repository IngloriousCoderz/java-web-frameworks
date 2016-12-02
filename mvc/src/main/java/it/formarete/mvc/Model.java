package it.formarete.mvc;

public class Model extends Observable {

	private String attribute;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
		publish(attribute);
	}
}
