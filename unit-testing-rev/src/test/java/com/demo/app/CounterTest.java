package com.demo.app;

//import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

//Entire object is being created everytime time so 0-->2 & 0-->-2 is working, to avoid we use
@TestInstance(Lifecycle.PER_CLASS) //counter test will be created only once
public class CounterTest {

//	CounterDemo c = new CounterDemo(); //dirty obj
	CounterDemo c = null;
	@BeforeEach //obj is created for each test case
	public void setUp() {
		c = new CounterDemo();
	}
	
	@AfterEach //garbage collection
	public void cleanup() {
		c = null;
	}
	
	@Test
	public void shouldReturn_a_value_2() {
		
		c.increment();
		c.increment();
		//Assertions.assertEquals(2, c.getCount());
		assertEquals(2, c.getCount());
	}
	@Test
	public void decrement_shouldReturn_minus2() {
		
		c.decrement();
		c.decrement();
		//Assertions.assertEquals(-2, c.getCount());
		assertEquals(-2, c.getCount());
	}
}
