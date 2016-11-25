package it.formarete.todos.test;

import it.formarete.todos.service.TodosDB;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TodosDBTest {

	private TodosDB db;

	@Before
	public void setUp() {
		db = new TodosDB();
	}

	@Test
	public void testGet() {
		assertEquals("Learn Struts", db.get(1).getTitle());
	}

	@Test
	public void testGetAll() {
		assertEquals(3, db.getAll().size());
	}

	@Test
	public void testCreate() {
		db.create("Profit");
		assertEquals(4, db.getAll().size());
		assertEquals("Profit", db.get(4).getTitle());
	}

	@Test
	public void testUpdate() {
		db.update(1, "Learn Struts2");
		assertEquals("Learn Struts2", db.get(1).getTitle());
	}

	@Test
	public void testDelete() {
		db.delete(2);
		assertEquals(2, db.getAll().size());
	}
}
