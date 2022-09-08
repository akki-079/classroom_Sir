package com.demo.test.bdd;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorStepDefs {
	Calculator cal;
	Integer a;
	Integer b;

	@Given("create the object of Calculator")
	public void create_the_object_of_calculator() {
		cal = new Calculator();
	}

	@When("I pass {int} and {int}")
	public void i_pass_and(Integer int1, Integer int2) {
		a = int1;
		b = int2;
		System.out.println("paramas pased..." + int1 + " and " + int2);
	}

	@Then("add method should return {int}")
	public void add_method_should_return(Integer int1) {
		Assertions.assertEquals(cal.add(a, b), int1);

	}

	@Given("with the object of Calculator")
	public void with_the_object_of_calculator() {
		cal = new Calculator();
	}

	@Then("sub method should return {int}")
	public void sub_method_should_return(Integer int1) {
		Assertions.assertEquals(cal.subtract(a, b), int1);
	}
}
