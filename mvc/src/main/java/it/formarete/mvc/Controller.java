package it.formarete.mvc;

public class Controller {

	private Model model;
	private View view;

	public void handleInput(String input, boolean updateView) {
		model.setAttribute(input);
		if (updateView) {
			String attribute = model.getAttribute();
			view.update(attribute);
		}
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setView(View view) {
		this.view = view;
	}
}
