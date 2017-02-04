package it.formarete.mvc;

public class Controller2 {

	private Model model;

	public void setModel(Model model) {
		this.model = model;
	}

	public void handleInput(String input) {
		model.setAttribute(input);
	}
}
