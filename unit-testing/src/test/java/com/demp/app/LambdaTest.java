package com.demp.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.app.MyCalculator;

public class LambdaTest {

	@Test
	public void testLambda() {
		MyCalculator cal = new MyCalculator();
		cal.calculate();
		assertEquals(40, cal.add);
		assertEquals(20, cal.sub);
		assertEquals(300, cal.mul);
		assertEquals(3, cal.divide);
	}

}
