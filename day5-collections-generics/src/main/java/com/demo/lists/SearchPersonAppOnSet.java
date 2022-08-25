package com.demo.lists;

import java.util.HashSet;
import java.util.Set;

public class SearchPersonAppOnSet {

	public static void main(String[] args) {
		Set<Person> personSet=new HashSet<>();
		//SortedSet<Person> personSet=new TreeSet<>();
		
		personSet.add(new Person(1,"Loki","Hyderabad"));
		personSet.add(new Person(5,"Thor","Hyderabad"));
		personSet.add(new Person(6,"Batman","Hyderabad"));
		personSet.add(new Person(7,"Iron Man","Hyderabad"));
		personSet.add(new Person(1,"John","Hyderabad"));
		personSet.add(new Person(2,"Peter","Hyderabad"));
		personSet.add(new Person(3,"Zeeta","Hyderabad"));
		personSet.add(new Person(4,"Marry","Hyderabad"));
		
		
		System.out.println(personSet);
		
		

	}

}
