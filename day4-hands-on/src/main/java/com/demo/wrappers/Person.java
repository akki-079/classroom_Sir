package com.demo.wrappers;

import java.util.Objects;

public class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;

	}

	public String getDetails() {
		return id + " " + name;
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) { //p1.equals(p2)
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			System.out.println("Failing for un equal class name");
			return false;
		}
		Person other = (Person) obj;
		return id == other.id;
	}
	
	
	
}
