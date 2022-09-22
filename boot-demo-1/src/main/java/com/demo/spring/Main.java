package com.demo.spring;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

	public static void main(String[] args) throws Exception {
		ObjectMapper objMapper = new ObjectMapper();
		Emp emp = new Emp(100, "John", "Bangalore", 65000.0);

		String jsonData = objMapper.writeValueAsString(emp);
		System.out.println(jsonData);
		
		String jsonString="{\"empId\":100,\"name\":\"John\",\"city\":\"Bangalore\",\"salary\":65000.0}";
		Emp emp2= objMapper.readValue(jsonString, Emp.class);
		
		System.out.println(emp2.getName());

	}

}
