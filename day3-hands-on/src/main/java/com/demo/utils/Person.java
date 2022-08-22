package com.demo.utils;

public class Person {
	private int id;
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
		return "An Employee Object with Emp ID "+id;
	}
}
