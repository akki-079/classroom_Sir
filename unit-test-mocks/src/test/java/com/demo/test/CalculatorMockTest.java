package com.demo.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.demo.maths.Calculator;

public class CalculatorMockTest {

	Calculator cal = mock(Calculator.class);
	
	@Test
	public void testCalMock() {
		System.out.println(cal.add(2, 2));
		System.out.println(cal.getClass().getName());
	}
	
	@Test
	public void testAdd() {
		when(cal.add(2, 2)).thenReturn(4);
		Assertions.assertEquals(4, cal.add(2,2));
	}
}
