package com.demo.lists;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;


public class SetDemo {

	public static void main(String[] args) {
		//Set<String> nameSet=new HashSet<>();
		SortedSet<String> nameSet=new TreeSet<>();
		
		nameSet.add("john");
		//namesList.add(1002);
		nameSet.add("peter");
		nameSet.add("harry");
		nameSet.add("srinivas");
		nameSet.add("peterson");
		System.out.println(nameSet);
		System.out.println(nameSet.contains("peter"));
		System.out.println(nameSet.size());
		nameSet.add("harry");
		
		//namesList.clear();
		System.out.println(nameSet);
		
		//old approach
		
		Iterator<String> itr=nameSet.iterator();
		
		while(itr.hasNext()) {
			
			String name=itr.next();
			
			System.out.println(name);
		}
		
		for(String name:nameSet) {
			System.out.println(name);
		}
		
		
		
		
		
		
		
		
		
		
	}

}
