package it.formarete.mytodos.service;

import it.formarete.mytodos.model.Todo;
import it.formarete.mytodos.model.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TodoDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Todo get(int id) {
		return (Todo) sessionFactory.getCurrentSession().get(Todo.class, id);
	}

	public int save(Todo todo) {
		return (Integer) sessionFactory.getCurrentSession().save(todo);
	}

	public void update(Todo todo) {
		sessionFactory.getCurrentSession().update(todo);
	}

	public void delete(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete from Todo where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Todo> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Todo.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Todo> getAll(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Todo where owner_id = :owner_id");
		query.setParameter("owner_id", user.getId());
		return query.list();
	}

	public void clear() {
		sessionFactory.getCurrentSession().createQuery("delete from Todo")
				.executeUpdate();
	}
}
