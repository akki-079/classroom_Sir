package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Dept;
import com.demo.entity.Emp;

public class Main1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Dept dept= session.get(Dept.class, 20);
			
			Emp e1=new Emp(117, "Naren", "Chennai", 80000.0);
			e1.setDept(dept);
			
			Emp e2=new Emp(118, "Prakash", "Bangalore", 70000.0);
			e2.setDept(dept);
			
			session.persist(e1);
			session.persist(e2);
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
