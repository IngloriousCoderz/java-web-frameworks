package it.formarete.mvc;

import java.util.ArrayList;
import java.util.List;
import it.formarete.mvc.Observer;

public class Observable {

	private List<Observer> observers;

	public Observable() {
		observers = new ArrayList<Observer>();
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public void publish(String attribute) {
		for (Observer observer : observers) {
			observer.wakeUp(attribute);
		}
	}
}
