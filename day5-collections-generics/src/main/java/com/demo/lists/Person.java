package com.demo.lists;

import java.util.Objects;

public class Person implements Comparable<Person>{
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private String name;
	private String location;

	public Person(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public String getDetails() {
		return id + " " + name + " " + location;
	}
	
	@Override
	public String toString() {
		return "("+id+" "+name+" "+location+")";
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode() is called");
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		Person other = (Person) obj;
		System.out.println("Equals called for Id "+other.id);
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		return id==other.id;
	}

	@Override
	public int compareTo(Person o) {
		
		return this.name.compareTo(o.getName());
	}

	
	
}
