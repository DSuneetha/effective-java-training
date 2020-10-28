package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;
import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;
import in.conceptarchitect.banking.exceptions.InvalidDenominationException;

public class CurrentAccountTests {

	int balance=10000;
	int minBalance=5000;
	CurrentAccount account;

	@Before
	public void init() {
		
		account=new CurrentAccount("suni","suni",balance);
		
	}

	@Test
	public void creditInterest_doesntCreditInterestToCurrentAccount() {

		account.creditInterest(12);
		assertEquals(balance, account.getBalance(),0);  //balance shouldn't change after crediting interest 
				
	}

	
	@Test
	public void withdraw_canWithdrawUptoBalanceUsingRightPassword() throws InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		account.withdraw(500, "suni");
		assertEquals(balance-500, account.getBalance(),0.01);
	}
	
	@Test
	public void withdraw_failsForInsufficientBalance() throws InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		account.withdraw(50000, "suni");
		assertEquals(expected, actual);
				assertNotEquals(balance<50000,account.getBalance()<50000);
	}
	
	@Test
	public void withdraw_failsForWrongPassword() {
		boolean result = account.withdraw(500, "hkcj");
		assertEquals(false, result);	

	}
	
	@Test
	public void withdraw_failsForNegativeAmount() {
		boolean result = account.withdraw(-500, "suni");
		assertEquals(false, result);	
	}
}
