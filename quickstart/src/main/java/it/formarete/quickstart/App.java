package it.formarete.quickstart;

import java.io.Serializable;

public class App implements Serializable {
	private static final long serialVersionUID = -1998213895574757883L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
