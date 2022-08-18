package com.demo.inheritance;

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
}
