package com.demo.maps;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		SortedMap<Integer, String> mobileData=new TreeMap<>();
		
		mobileData.put(98496569, "John");
		mobileData.put(89897654, "Peter");
		mobileData.put(78978900, "Zeeta");
		mobileData.put(65789760, "Kiran");
		mobileData.put(78675678, "Jane");
		mobileData.put(78654320, "Monika");
		
		System.out.println(mobileData);
		
		System.out.println(mobileData.get(78978900));
		
		mobileData.remove(65789760);
		System.out.println(mobileData);
		
		Set<Integer> keys=mobileData.keySet();
		
		for(Integer key:keys) {
			
			System.out.println(key+" ---->"+mobileData.get(key));
		}
		
		
	}
}
