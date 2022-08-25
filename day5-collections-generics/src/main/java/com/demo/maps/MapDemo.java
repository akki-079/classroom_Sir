package com.demo.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, String> mobileData=new HashMap<>();
		
		mobileData.put(98496569, "John");
		mobileData.put(89897654, "Peter");
		mobileData.put(78978900, "Zeeta");
		mobileData.put(65789760, "Kiran");
		mobileData.put(78675678, "Jane");
		mobileData.put(78654320, "Monika");
		
		System.out.println(mobileData);
		
		String name=mobileData.get(78978900);
		
		mobileData.remove(65789760);
		System.out.println(mobileData);
		
		Set<Integer> keys=mobileData.keySet();
		
		for(Integer key:keys) {
			
			System.out.println(key+" ---->"+mobileData.get(key));
		}
		
		//task: sort the map in descending order
		
		//----
		if(mobileData.containsKey(78978900))
			System.out.println("Mobile Data exists");
		else System.out.println("Number not found..");
		
	}
}
