package it.formarete.mvc;

public class View implements IObserver {
	private String template;
	private String output;

	public View() {
		template = "<h1>Hello ${variable}!</h1>";
		update("nobody");
	}

	public void update(String variable) {
		this.output = template.replace("${variable}", variable);
	}

	public String getOutput() {
		return output;
	}

	@Override
	public void wakeUp(String attribute) {
		update(attribute);
	}
}
