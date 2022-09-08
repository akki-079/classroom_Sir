package com.demp.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.demo.app.Calculator;

public class CalculatorTest {

	@Test
	@Disabled
	public void testJupiterSetup() {
		System.out.println("Test Done");
	}
	
	
	@DisplayName("Tests the counter for 2 increments")
	@RepeatedTest(value = 4)
	public void testAddfor2ints() {
		Calculator cal= new Calculator();
		Assertions.assertEquals(6, cal.add(3,3));
	}
}
