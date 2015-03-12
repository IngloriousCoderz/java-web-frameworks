package it.formarete.todos.model;

public class Todo {
	private int id;
	private String title;

	public Todo() {
	}

	public Todo(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
