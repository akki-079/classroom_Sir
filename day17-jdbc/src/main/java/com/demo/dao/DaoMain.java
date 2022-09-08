package com.demo.dao;

import com.demo.entity.Emp;
import com.demo.exceptions.EmpNotFoundException;

public class DaoMain {

	public static void main(String[] args)  {
		EmpDao dao=new EmpDaoJdbcImpl();
		
		Emp e;
		try {
			e = dao.findById(1020);
			System.out.println(e.getName()+" "+e.getSalary());
		} catch (EmpNotFoundException e1) {
			System.out.println("Emp Not Found..");
		}
		
		

	}

}
