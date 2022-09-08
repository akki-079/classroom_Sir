package com.demp.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.demo.app.Calculator;

public class ParametrizedDemoTest {
	Calculator cal = new Calculator();

	@ParameterizedTest
	@ValueSource(strings = { "hello", "world", "zoo", "animals" })
	public void testArgs(String param) {
		assertNotNull(param);
	}

	@ParameterizedTest
	@CsvSource({ "1, 1, 2", "2, 3, 5" })
	public void testAddForData(int a, int b, int result) {
		assertEquals(result, cal.add(a, b));
	}
	
	@ParameterizedTest
	@CsvFileSource(files = {"data.csv"})
	public void testAddForCSVData(int a, int b, int result) {
		assertEquals(result, cal.add(a, b));
	}

}
