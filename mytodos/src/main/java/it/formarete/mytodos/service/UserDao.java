package it.formarete.mytodos.service;

import it.formarete.mytodos.model.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User get(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from User where name = :name");
		query.setParameter("name", name);
		return (User) query.uniqueResult();
	}

	public int save(User user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public void delete(String name) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete from User where name = :name");
		query.setParameter("name", name);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public void clear() {
		sessionFactory.getCurrentSession().createQuery("delete from User")
				.executeUpdate();
	}
}
