package it.formarete.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import it.formarete.model.Employee;
import it.formarete.service.EmployeeDAO;

public class EmployeeDAOTestCase {
	@Test
	public void testCrud() {
		Employee employee = new Employee();
		employee.setName("Antony");
		employee.setSalary(5450);

		/* retrieve */
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> employees = dao.getAll();
		assertNotNull(employees);
		assertTrue(employees.isEmpty());

		/* create */
		int id = dao.save(employee);
		assertTrue(id > 0);
		employee = dao.get(id);
		assertEquals(id, employee.getId());
		employees = dao.getAll();
		assertEquals(1, employees.size());

		/* update */
		employee.setSalary(employee.getSalary() * 2);
		dao.update(employee);
		employee = dao.get(employee.getId());
		assertEquals(10900f, employee.getSalary(), 0);
		employees = dao.getAll();
		assertEquals(1, employees.size());

		/* delete */
		dao.delete(employee);
		employee = dao.get(employee.getId());
		assertNull(employee);
		employees = dao.getAll();
		assertTrue(employees.isEmpty());
	}
}
