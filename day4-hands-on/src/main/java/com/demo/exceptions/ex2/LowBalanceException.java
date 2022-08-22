package com.demo.exceptions.ex2;

public class LowBalanceException extends Exception {
	public LowBalanceException() {

	}

	public LowBalanceException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " : " + super.getMessage();
	}
}
