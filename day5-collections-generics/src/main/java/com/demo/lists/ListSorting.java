package com.demo.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorting {

	public static void main(String[] args) {
		List<Person> personList=new ArrayList<>();
		personList.add(new Person(1,"John","Hyderabad"));
		personList.add(new Person(2,"Peter","Hyderabad"));
		personList.add(new Person(3,"Johnny","Hyderabad"));
		personList.add(new Person(4,"Kiran","Hyderabad"));
		personList.add(new Person(5,"Kinnar","Hyderabad"));
		personList.add(new Person(6,"Jugal","Hyderabad"));
		
		personList.sort((p1,p2)->p1.getName().compareTo(p2.getName()));
		
		System.out.println(personList);
		
		
		
		

	}

}


