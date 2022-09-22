package com.demo.spring.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.demo.spring.entity.Emp;

public class Data {
	private static Map<Integer, Emp> data = new ConcurrentHashMap<>();

	public static Map<Integer, Emp> getData() {
		return data;
	}

	public static void setData(Map<Integer, Emp> data) {
		Data.data = data;
	}
	
	
}
