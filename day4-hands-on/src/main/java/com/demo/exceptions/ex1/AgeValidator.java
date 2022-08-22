package com.demo.exceptions.ex1;

public class AgeValidator {

	public String validateAge(int age) throws InvalidAgeException {
		try {
			if (age < 18) {
				throw new InvalidAgeException("You are not allowed here");
			} else if (age > 60) {
				throw new InvalidAgeException("You are too old to be allowed..");
			} else {
				return "Welcome to the stage";
			}
		} catch (InvalidAgeException e) {
			throw e;
		}
	}
}
