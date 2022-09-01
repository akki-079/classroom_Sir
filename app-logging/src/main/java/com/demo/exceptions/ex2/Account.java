package com.demo.exceptions.ex2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Account {

	private double balance;
	
	private Logger LOGGER= LogManager.getLogger(this.getClass().getName());

	public Account() {

		LOGGER.info("AN Account Object is created");
	}

	public Account(double balance) {
		LOGGER.info("Account Balance updated");
		this.balance = balance;
	}

	public double deposit(double amount) {
		this.balance = this.balance + amount;
		LOGGER.info("amount {} deposited successfully",amount);
		return this.balance;
	}

	public double withdraw(double amount) throws LowBalanceException {
		LOGGER.info("withdraw process started...");
		try {
			if (amount > balance) {
				LOGGER.error("balance is low in the account");
				throw new LowBalanceException("Balance is Low");
			} else {
				this.balance = this.balance - amount;
				LOGGER.info("Transaction sucessful");
				return this.balance;
			}
		} catch (LowBalanceException e) {
			LOGGER.error("withdraw is in error condition : {} ",e.fillInStackTrace());
			throw e;
		}

	}

	public double getBalance() {
		return this.balance;
	}
}
