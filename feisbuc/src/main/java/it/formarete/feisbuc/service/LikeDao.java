package it.formarete.feisbuc.service;

import it.formarete.feisbuc.model.Like;
import it.formarete.feisbuc.model.Post;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class LikeDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Like get(int id) {
		return (Like) sessionFactory.getCurrentSession().get(Like.class, id);
	}

	public int save(Like like) {
		return (Integer) sessionFactory.getCurrentSession().save(like);
	}

	public void update(Like like) {
		sessionFactory.getCurrentSession().update(like);
	}

	public void delete(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"delete from Like where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Like> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Like.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Like> getAll(Post post) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Like where post = :post").setParameter("post", post)
				.list();
	}

	public void clear() {
		sessionFactory.getCurrentSession().createQuery("delete from Like")
				.executeUpdate();
	}
}
