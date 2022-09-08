package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Dept;
import com.demo.entity.Emp;

public class LazyDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Dept dept= session.get(Dept.class, 20);
			
			dept.getEmps().forEach(e->System.out.println(e.getName()));
		
			tx.commit();
			
			
			
			
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
