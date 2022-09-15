package com.demo.factory.ex1;

import java.util.Optional;

public class CycleFactory {

	public static Optional<Cycle> createCycle(String input) {
		if (input.equals("uni")) {
			return Optional.of(new UniCycle());
		} else if (input.equals("bi")) {
			return Optional.of(new BiCycle());
		} else if (input.equals("tri")) {
			return Optional.of(new TriCycle());
		} else {
			return Optional.empty();
		}
	}
}
