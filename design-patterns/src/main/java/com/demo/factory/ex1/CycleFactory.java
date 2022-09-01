package com.demo.factory.ex1;

public class CycleFactory {

	public static Cycle createCycle(String input) {
		if (input.equals("uni")) {
			return new UniCycle();
		} else if (input.equals("bi")) {
			return new BiCycle();
		} else if (input.equals("tri")) {
			return new TriCycle();
		} else {
			throw new RuntimeException("Cycle not supported");
		}
	}
}
