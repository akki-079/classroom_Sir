package com.demo.exceptions.ex1;

public class AgeValidationMain {

	public static void main(String[] args) {
		
		AgeValidator ageValidator = new AgeValidator();
		try {
		System.out.println(ageValidator.validateAge(61));
		}catch (InvalidAgeException e) {
			//System.out.println("You are not allowed here");
			System.out.println(e);
		}
		System.out.println("Validation done successfully..");

	}

}
