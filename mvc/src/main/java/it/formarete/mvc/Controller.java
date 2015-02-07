package it.formarete.mvc;

public class Controller {
	private Model model;
	private View view;

	public void handleInput(String input) {
		model.setAttribute(input);
	}

	public void updateView(String attribute) {
		view.update(attribute);
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}
}
