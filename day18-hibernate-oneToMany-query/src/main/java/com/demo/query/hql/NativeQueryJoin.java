package com.demo.query.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.entity.Emp;

public class NativeQueryJoin {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
		
						
			List<Object[]> empList=session.createNativeQuery("select e.name,e.salary,d.dname,d.manager from myemp e join mydept d on e.dno=d.dno").list();
			
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
