package com.demo.query.hql;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf;

	private HibernateUtil() {

	}

	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			Configuration cfg = new Configuration().configure();
			sf = cfg.buildSessionFactory();
			return sf;
		} else {
			return sf;
		}

	}
}
