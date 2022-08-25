package com.demo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtil {

	public static void main(String[] args) {
		
		List<String> namesList = new ArrayList<>();

		namesList.add("john");
		namesList.add("peter");
		namesList.add("harry");
		namesList.add("srinivas");
		namesList.add(0, "peterson");
		
		List<String> immutableList=Collections.unmodifiableList(namesList);
		System.out.println(immutableList);
		immutableList.add("Lion");
		
		List<String> synchList=Collections.synchronizedList(namesList);
		
		
	}

}
