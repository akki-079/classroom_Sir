package com.demo.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.maths.Counter;

@TestInstance(Lifecycle.PER_CLASS)
public class CounterTest {
	Counter counter;

	@BeforeEach
	public void init() {
		System.out.println("BeforeEach executed....");
		counter = new Counter();
	}

	@AfterEach
	public void cleanUp() {
		System.out.println("AfterEach executed....");
		counter = null;
	}
	
	@Test
	public void shouldReturnZero() {
		Assertions.assertEquals(0, counter.getCounter());
	}
	
	@RepeatedTest(value = 4)
	@DisplayName("incrTest")
	public void testIncrement() {
		counter.increment();
		counter.increment();
		counter.increment();
		Assertions.assertEquals(3, counter.getCounter());
	}
	
	@Test
	public void testDecrement() {
		counter.decrement();
		counter.decrement();
		
		Assertions.assertEquals(-2, counter.getCounter());
	}
}
