package it.formarete.test;

import it.formarete.model.Employee;
import it.formarete.service.EmployeeDAO;

import java.util.List;

import junit.framework.TestCase;

public class EmployeeDAOTestCase extends TestCase {
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
		assertEquals(10900f, employee.getSalary());
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
