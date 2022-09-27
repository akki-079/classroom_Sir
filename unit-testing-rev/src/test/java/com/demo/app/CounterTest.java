package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class CounterTest {

	CounterDemo c = null;

	@BeforeEach
	public void setUp() {
		c = new CounterDemo();
	}

	@AfterEach
	public void cleanUp() {
		c = null;
	}

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
