package it.formarete.service;

import it.formarete.model.Employee;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;

public class EmployeeDAO {
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public int save(Employee employee) {
		return (Integer) template.save(employee);
	}

	public void update(Employee employee) {
		template.update(employee);
	}

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
