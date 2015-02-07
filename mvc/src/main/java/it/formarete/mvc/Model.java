package it.formarete.mvc;

public class Model extends Publisher {
	private String attribute;

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
		publish(attribute);
	}
}
