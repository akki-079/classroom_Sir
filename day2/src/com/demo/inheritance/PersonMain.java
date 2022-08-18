package com.demo.inheritance;

public class PersonMain {

	public static void main(String[] args) {
		
		Person peter= new Person(101,"Peter","Bangalore");
		Student st= new Student(100,"John","Hyderabad","Excellent");
		
		System.out.println(peter.getDetails());
		System.out.println(st.getDetails());

	}

}
