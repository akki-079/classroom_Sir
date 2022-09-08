package com.demo.test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.maths.Calculator;

@ExtendWith(MockitoExtension.class)
public class CalculatorMockTest3 {

	@Spy
	Calculator cal;

	@Test
	public void testAdd() {
		System.out.println(cal.getClass().getName());
		when(cal.add(2, 2)).thenReturn(4);
		Assertions.assertEquals(4, cal.add(2, 2));
	}
	
	@Test
	public void verifyTestAdd() {
		cal.add(2, 2);
		cal.add(2, 2);
		verify(cal,times(2)).add(2, 2);
	}
}
