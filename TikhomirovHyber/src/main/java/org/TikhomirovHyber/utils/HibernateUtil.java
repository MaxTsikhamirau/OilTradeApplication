package org.TikhomirovHyber.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			System.out.println("Trying to create Session factory");
			sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("Session factory created");
		} catch (Throwable ex) {
			System.out.println("Failed to create Session factory");
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	

}
