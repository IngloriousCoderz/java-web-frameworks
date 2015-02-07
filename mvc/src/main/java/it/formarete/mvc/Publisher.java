package it.formarete.mvc;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
	private List<ISubscriber> subscribers;

	public Publisher() {
		subscribers = new ArrayList<ISubscriber>();
	}

	public void addSubscriber(ISubscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void removeSubscriber(ISubscriber subscriber) {
		subscribers.remove(subscriber);
	}

	public void publish(String attribute) {
		for (ISubscriber subscriber : subscribers) {
			subscriber.wakeUp(this, attribute);
		}
	}
}
