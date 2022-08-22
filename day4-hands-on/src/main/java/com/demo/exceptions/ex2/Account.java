package com.demo.exceptions.ex2;

public class Account {

	private double balance;

	public Account() {

	}

	public Account(double balance) {
		this.balance = balance;
	}

	public double deposit(double amount) {
		this.balance = this.balance + amount;
		return this.balance;
	}

	public double withdraw(double amount) throws LowBalanceException {

		try {
			if (amount > balance) {
				throw new LowBalanceException("Balance is Low");
			} else {
				this.balance = this.balance - amount;
				System.out.println(" Transaction sucessful");
				return this.balance;
			}
		} catch (LowBalanceException e) {
			throw e;
		}

	}

	public double getBalance() {
		return this.balance;
	}
}
