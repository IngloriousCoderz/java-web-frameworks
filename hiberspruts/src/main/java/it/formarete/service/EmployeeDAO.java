package it.formarete.service;

import it.formarete.model.Employee;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDAO {
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional(readOnly = false)
	public int save(Employee employee) {
		return (Integer) template.save(employee);
	}

	@Transactional(readOnly = false)
	public void update(Employee employee) {
		template.update(employee);
	}

	@Transactional(readOnly = false)
	public void delete(Employee employee) {
		template.update(employee);
	}

	public Employee get(int id) {
		return template.get(Employee.class, id);
	}

	public List<Employee> getAll() {
		return template.loadAll(Employee.class);
	}
}
