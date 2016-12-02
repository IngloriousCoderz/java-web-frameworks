package it.formarete.service;

import it.formarete.model.Employee;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAO {

	public int save(Employee employee) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		int id = (Integer) session.save(employee);
		transaction.commit();
		session.close();

		return id;
	}

	public void update(Employee employee) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(employee);
		transaction.commit();
		session.close();
	}

	public void delete(Employee employee) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(employee);
		transaction.commit();
		session.close();
	}

	public Employee get(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		transaction.commit();
		session.close();

		return employee;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> employees = session.createCriteria(Employee.class).list();
		transaction.commit();
		session.close();

		return employees;
	}
}
