package it.formarete.service;

import it.formarete.model.Employee;

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
}
