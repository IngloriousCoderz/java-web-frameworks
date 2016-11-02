package it.formarete.mvc;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private List<IObserver> observers;

	public Observable() {
		observers = new ArrayList<IObserver>();
	}

	public void addObserver(IObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(IObserver observer) {
		observers.remove(observer);
	}

	public void publish(String attribute) {
		for (IObserver observer : observers) {
			observer.wakeUp(attribute);
		}
	}
}
