package it.formarete.mvc;

public class View implements ISubscriber {
	private String template;
	private String output;

	public View() {
		template = "<h1>Hello ${attribute}!</h1>";
		update("nobody");
	}

	public void update(String attribute) {
		this.output = template.replace("${attribute}", attribute);
	}

	public String getOutput() {
		return output;
	}

	@Override
	public void wakeUp(Publisher publisher, String attribute) {
		update(attribute);
	}
}
