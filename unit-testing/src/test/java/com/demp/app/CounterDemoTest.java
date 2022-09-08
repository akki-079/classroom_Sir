package com.demp.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.demo.app.CounterDemo;

@TestInstance(Lifecycle.PER_CLASS)
public class CounterDemoTest {

	CounterDemo counter;

	@BeforeEach
	public void init() {
		counter = new CounterDemo();
	}

	@Test
	public void testIncrement2times() {
		counter.increment();
		counter.increment();
		assertEquals(2, counter.getCount());
	}

	@Test
	public void testDecrement2times() {
		System.out.println(counter.getCount());
		counter.decrement();
		counter.decrement();
		int count = counter.getCount();
		System.out.println(count);
		assertEquals(-2, count);
	}

	@AfterEach
	public void cleanup() {
		counter = null;
	}
}
