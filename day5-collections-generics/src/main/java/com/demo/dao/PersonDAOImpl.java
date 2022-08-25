package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.demo.lists.Person;

public class PersonDAOImpl implements PersonDAO {
	private List<Person> personDB;

	public PersonDAOImpl() {
		personDB = new ArrayList<>();
		personDB.add(new Person(100, "John", "Hyderabad"));
		personDB.add(new Person(101, "Peter", "Bangalore"));
		personDB.add(new Person(103, "Vedha", "Chennai"));
	}

	
	@Override
	public Person findById(int id) {

		for(Person p: personDB) {
			if(id==p.getId()) {
				return p;
			}
		}
		return null; //very dangerous
	}

	@Override
	public String save(Person p) {
		personDB.add(p);
		return "Person Added";
	}

	@Override
	public String delete(int id) {

		Person p=this.findById(id);
		if(p==null)
		return "Person does not exist";
		else {
			personDB.remove(p);
			return "Person deleted";
		}
		
	}

	@Override
	public String update(Person p) {
		Person person=this.findById(p.getId());
		if(person==null) {
			return "Person does not exist";
		}else {
			person.setId(p.getId());
			person.setName(p.getName());
			person.setLocation(p.getLocation());
			return "Person Updated";
		}
	}

	@Override
	public List<Person> findAll() {

		return personDB;
	}

	
}
