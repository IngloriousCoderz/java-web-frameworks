package it.formarete.mvc.decorator;

import it.formarete.mvc.Model;
import it.formarete.mvc.Observer;
import java.util.ArrayList;
import java.util.List;

public class ObservableDecorator implements Model {

	private List<Observer> observers;
	private Model decorated;

	public ObservableDecorator(Model decorated) {
		this.decorated = decorated;
	}

	public void addObserver(Observer observer) {
		if (observers == null) {
			observers = new ArrayList<Observer>();
		}
		observers.add(observer);
	}

	public void publish(String attribute) {
		for (Observer observer : observers) {
			observer.wakeUp(attribute);
		}
	}

	@Override
	public String getAttribute() {
		return decorated.getAttribute();
	}

	@Override
	public void setAttribute(String attribute) {
		decorated.setAttribute(attribute);
		publish(attribute);
	}
}
