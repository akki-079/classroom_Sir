package com.ex2.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreeterMain {
	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		GreetService greeter = (GreetService) ctx.getBean("greetService");

		greeter.greet();

	}
}
