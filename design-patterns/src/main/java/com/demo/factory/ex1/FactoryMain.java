package com.demo.factory.ex1;

import java.util.Optional;

public class FactoryMain {

	public static void main(String[] args) {
		Optional<Cycle> c= CycleFactory.createCycle("bii");
		if(c.isPresent()) {
		System.out.println(c.get().getCycleDetails());
		}

	}

}
