package it.formarete.mvc.strategy;

import it.formarete.mvc.Model;
import it.formarete.mvc.Observable;
import it.formarete.mvc.Observer;

public class ModelWithObservable implements Model {
	
	private String attribute;
	private Observable observable;
	
	public ModelWithObservable() {
		observable = new Observable();
	}
	
	@Override
	public String getAttribute() {
		return attribute;
	}
	
	@Override
	public void setAttribute(String attribute) {
		this.attribute = attribute;
		observable.publish(attribute);
	}
	
	public void addObserver(Observer observer) {
		observable.addObserver(observer);
	}
}
