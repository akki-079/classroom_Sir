package com.demo.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcHasMapNoPool {

	public static void main(String[] args) throws Exception{
		Map<String, String> dataMap=new ConcurrentHashMap<>();
		
		Thread t1= new Thread(new MapWriter(dataMap));
		Thread t2=new Thread(new MapWriter(dataMap));
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("The Size of Map : "+dataMap.size());
	}

}
