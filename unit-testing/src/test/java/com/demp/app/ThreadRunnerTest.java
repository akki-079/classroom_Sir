package com.demp.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.demo.app.ThreadRunner;

public class ThreadRunnerTest {

	@Test
	public void testThreadData() throws Exception {
		ThreadRunner threadRunner = new ThreadRunner();
		threadRunner.runThread();
		int num = threadRunner.getData().get(0).getNumber();
		int square = threadRunner.getData().get(0).getSquare();

		assertTrue(num * num == square);
	}
}
