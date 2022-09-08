package com.demo.query.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.demo.entity.Emp;

public class HQLProjection {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			
			Query<Data> query=session.createQuery("select new com.demo.query.hql.Data(e.empId,e.name,e.salary) from Emp e where e.name like 'Sh%'",Data.class);
			
			
			List<Data> objList=query.getResultList();
			for(Data d:objList) {
				
				
				System.out.println(d.getName()+" "+d.getSalary());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
