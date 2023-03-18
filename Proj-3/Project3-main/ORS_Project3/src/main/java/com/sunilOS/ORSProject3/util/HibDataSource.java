package com.sunilOS.ORSProject3.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate DataSource is provides the object of sessionfactory and session
 * 
 * @author Rishabh Gurjar
 *
 */

public final class HibDataSource {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			// Configuration cfg= new Configuration();
			// sessionFactory=cfg.configure().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static Session getSession() {
		Session session = getSessionFactory().openSession();
		return session;
	}

	public static void closeConnection(Session session) {
		if (session == null) {
			session.close();
		}
	}

}
