package it.formarete.mvc;

public interface ISubscriber {
	public void wakeUp(Publisher publisher, String attribute);
}
