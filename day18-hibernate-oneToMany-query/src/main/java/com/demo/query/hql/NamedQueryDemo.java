package com.demo.query.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.entity.Emp;

public class NamedQueryDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			
			Query<Emp> query=session.createNamedQuery("demo2", Emp.class);
			
			List<Emp> empList=query.getResultList();
			
			empList.forEach(e->System.out.println(e.getName()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
