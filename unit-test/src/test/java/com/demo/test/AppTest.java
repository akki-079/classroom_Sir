package com.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.maths.Calculator;

@TestInstance(Lifecycle.PER_CLASS)
public class AppTest {
	
	Calculator cal;
	
	@BeforeAll
	public void init() {
		System.out.println("Calculator initialized..");
		cal=new Calculator();
	}

	
	
	@Test
	public void shouldReturnHello() {
		System.out.println("Hello there, Jupiter is OK");
	}
	
	@Test
	public void testAdd() {
		
		assertEquals(5, cal.add(3, 3));
	}
	
	@Test
	public void testSubtract() {
		
		assertEquals(3, cal.subtract(6, 3));
	}
	
	@Test
	public void shouldThrowException() {
		
		ArithmeticException ex= Assertions.assertThrows(ArithmeticException.class, ()->cal.divide(5, 0));
		
		Assertions.assertTrue(ex.getMessage().contains("/ by zero"));
	}
	
	@AfterAll
	public void cleanup() {
		System.out.println("Calculator de referenced..");
		cal=null;
	}
}
