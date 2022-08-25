package com.demo.dao;

import com.demo.lists.Person;

public class Main2 {

	public static void main(String[] args) {
		PersonDAO dao=new PersonDAOImpl();

		System.out.println(dao.findAll());
		dao.save(new Person(102,"Nilam","Mumbai"));
		System.out.println(dao.findById(102));
		
		System.out.println(dao.delete(106));
		System.out.println(dao.delete(102));
		
		System.out.println(dao.findAll());
	}

}
