package com.demo.exceptions.ex2;

public class Main2 {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.createAccount(5000);
		Account account = bank.getAccount();

		account.deposit(5000);
		account.deposit(25000);
		System.out.println("Current Balance is " + account.getBalance());
		try {
			account.withdraw(10000);
			account.withdraw(27000);
		} catch (LowBalanceException e) {
			System.out.println(e);
		}

	}

}
