package com.demo.factory.ex1;

public interface Cycle {

	public String getCycleDetails();
}

class TriCycle implements Cycle{

	
	public String getCycleDetails() {
		
		return "Tricycle with 3 wheels";
	}
	
}

class BiCycle implements Cycle{

	
	public String getCycleDetails() {
		
		return "BiCycle with 2 wheels";
	}
	
}

class UniCycle implements Cycle{

	
	public String getCycleDetails() {
		
		return "Unicycle with 1 wheel";
	}
	
}
