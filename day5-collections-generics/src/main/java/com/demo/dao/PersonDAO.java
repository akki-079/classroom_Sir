package com.demo.dao;

import java.util.List;

import com.demo.lists.Person;

interface PersonDAO {
//CRUD Operations
	public Person findById(int id);
	public String save(Person p);
	public String delete(int id);
	public String update(Person p);
	public List<Person> findAll();
	
}
