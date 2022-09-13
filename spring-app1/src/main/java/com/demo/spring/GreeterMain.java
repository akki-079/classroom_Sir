package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreeterMain {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("greet-context.xml");

		GreetService greetService1 = (GreetService) ctx.getBean("greetBean");

		greetService1.greet();
		
		GreetService greetService2 = (GreetService) ctx.getBean("greetBean");
		
		System.out.println(greetService1==greetService2);
		
		
	}
}
