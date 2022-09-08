package com.demo.test;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.maths.Calculator;

@ExtendWith(MockitoExtension.class)
public class CalculatorMockTest2 {

	@Mock
	Calculator cal;
	
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
