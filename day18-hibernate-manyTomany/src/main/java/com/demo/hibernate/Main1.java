package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.Course;
import com.demo.entity.Student;

public class Main1 {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {

			Course maths=new Course("maths");
			Course chem=new Course("chemistry");
			Course phy=new Course("physics");
			session.persist(maths);
			session.persist(phy);
			session.persist(chem);
			
			Student john=new Student("John");
			Student smith=new Student("Smith");
			Student jenny=new Student("Jenny");
			
			john.getCourses().add(maths);
			john.getCourses().add(chem);
			
			smith.getCourses().add(maths);
			smith.getCourses().add(phy);
			
			jenny.getCourses().add(chem);
			jenny.getCourses().add(maths);
			
			session.persist(jenny);
			session.persist(john);
			session.persist(smith);
			
			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			HibernateUtil.getSessionFactory().close();
		}

	}

}
