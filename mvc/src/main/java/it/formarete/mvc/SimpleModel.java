package it.formarete.mvc;

public class SimpleModel implements Model {

	private String attribute;

	@Override
	public String getAttribute() {
		return attribute;
	}

	@Override
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
}
