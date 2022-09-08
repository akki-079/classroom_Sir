package com.demp.app;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.demo.exceptions.ex2.Account;
import com.demo.exceptions.ex2.LowBalanceException;

public class TestThrows {

@Test
public void testLowBalanceException() {
	Account account=new Account();
	account.deposit(5000);
	LowBalanceException exception=assertThrows(LowBalanceException.class, ()->{account.withdraw(5001);});
	assertTrue(exception.getMessage().contains("Balance is Low"));
}
}
