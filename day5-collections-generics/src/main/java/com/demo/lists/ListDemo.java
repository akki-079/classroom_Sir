package com.demo.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {
		List<String> namesList = new ArrayList<>();

		namesList.add("john");
		// namesList.add(1002);
		namesList.add("peter");
		namesList.add("harry");
		namesList.add("srinivas");
		namesList.add(0, "peterson");
		namesList.remove(2);
		System.out.println(namesList);
		System.out.println(namesList.contains("peter"));
		System.out.println(namesList.size());
	String name1=	namesList.get(3);
		// namesList.clear();
		System.out.println(namesList);

		// old approach

		/*
		 * Iterator<String> itr=namesList.iterator();
		 * 
		 * while(itr.hasNext()) {
		 * 
		 * String name=itr.next();
		 * 
		 * System.out.println(name); }
		 * 
		 * for(String name:namesList) { System.out.println(name); }
		 */

		ListIterator<String> ltr = namesList.listIterator();

		while (ltr.hasNext()) {
			String name = ltr.next();
			System.out.println(name);

		}

		System.out.println("==================");
		while (ltr.hasPrevious()) {
			String name = ltr.previous();
			System.out.println(name);
		}

		Collections.sort(namesList, new ListSorter());

		System.out.println(namesList);

	}

}

class ListSorter implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {

		return o2.compareTo(o1);
	}
}
