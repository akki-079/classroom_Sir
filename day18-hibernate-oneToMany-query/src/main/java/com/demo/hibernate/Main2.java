package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Dept;
import com.demo.entity.Emp;

public class Main2 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();

		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Dept dept= session.get(Dept.class, 20);
			
			Emp e1=new Emp(119, "Raja", "Chennai", 80000.0);
			
			
			Emp e2=new Emp(120, "Ranga", "Bangalore", 70000.0);
			
			dept.getEmps().add(e1);
			dept.getEmps().add(e2);
			
			session.merge(dept);
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
