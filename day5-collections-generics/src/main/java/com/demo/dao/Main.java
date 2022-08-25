package com.demo.dao;

import com.demo.lists.Person;

public class Main {

	public static void main(String[] args) {
		PersonDAO dao=new PersonDAOImpl();

		System.out.println(dao.findAll());
		dao.save(new Person(102,"Nilam","Mumbai"));
		Person p=dao.findById(102);
		System.out.println(p);
		
		p.setLocation("Delhi");
		
		dao.update(p);
		
		System.out.println(dao.findAll());
	}

}
