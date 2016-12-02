package it.formarete.model;

public class BestUserInTheWorld implements IUser {

	private String name;

	@Override
	public String getName() {
		return "mighty " + name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
