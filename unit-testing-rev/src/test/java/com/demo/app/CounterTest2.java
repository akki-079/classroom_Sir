package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CounterTest2 {

	public CounterTest2() {
		System.out.println(" Test instance created..");
	}

	CounterDemo c = new CounterDemo();

	@Test
	public void shouldReturn_a_value_2() {
		c.increment();
		c.increment();
		assertEquals(2, c.getCount());
	}

	@Test
	public void decrement_shouldReturn_minus2() {
		c.decrement();
		c.decrement();
		assertEquals(-2, c.getCount());
	}
}
