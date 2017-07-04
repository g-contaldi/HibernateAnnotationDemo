package it.dstech.dao;

import java.util.List;

import org.hibernate.Session;

import it.dstech.config.HibernateUtil;

public abstract class HibernateDao {

	private static Session session;

	public static Session getSession() {
		return session;
	}

	public static Session createSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		return session;
	}

	public static void closeSession() {
		session.close();
	}

	static Object persist(Object object) {
		session.beginTransaction();
		session.persist(object);
		session.getTransaction().commit();
		return object;
	}

	@SuppressWarnings("rawtypes")
	static List getAll(String queryHQL) {
		return session.createQuery(queryHQL).list();
	}

	static Object update(Object object) {
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
		return object;
	}

	static Object delete(Object object) {
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		return object;
	}

}
