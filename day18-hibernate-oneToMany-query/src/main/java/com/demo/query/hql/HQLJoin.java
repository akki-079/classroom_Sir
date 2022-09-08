package com.demo.query.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.entity.Emp;

public class HQLJoin {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
		
			
		
			Query<Object[]> query=session.createQuery("select e.name,e.salary,d.deptName,d.manager from Dept d join d.emps e",Object[].class);
			
			List<Object[]> empList=query.getResultList();
			
			for(Object[] o:empList) {
				String name=(String)o[0];
				Double salary=(Double)o[1];
				String dname=(String)o[2];
				String manager=(String)o[3];
				System.out.println(name+" "+salary+" "+dname+" "+manager);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
