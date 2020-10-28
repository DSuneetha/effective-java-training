package in.conceptarchitect.banking.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.CurrentAccount;
import in.conceptarchitect.banking.SavingsAccount;
import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;
import in.conceptarchitect.banking.exceptions.InvalidDenominationException;

public class SavingsAccountTests {

	SavingsAccount account;
	String name="Vivek";
	String password="p@ss";
	int balance=15000;
	int minBalance=5000;

	@Before
	public void init() {
		
		account=new SavingsAccount(name, password, balance);
		
	}
	
	@Test
	public void withdraw_failsForWrongPassword() throws InvalidCredentialsException, InsufficientBalanceException, InvalidDenominationException {
		account.withdraw(1, "wrong-password");
	
	}
	
	
	@Test
	public void withdraw_failsIfNetBalancePostWithdrawRedudesBelowMinBalance() throws InsufficientBalanceException, InvalidCredentialsException, InvalidDenominationException {
		
		 account.withdraw(balance-minBalance+1, password);		
		
	}
	
	@Test
	public void withdraw_succeedsIfPostWithdrawMinBalanceIsAvailable() {
		boolean result=account.withdraw(balance-minBalance, password);
		assertTrue(result);
	}
	
	@Test
	public void withdraw_reducesTheBalance() throws InsufficientBalanceException, InvalidCredentialsException, InvalidDenominationException {
		
		account.withdraw(1000, password);
		
		assertEquals(balance-1000, account.getBalance(),0.01);
	}
	
	@Test
	public void creditInterest_addsMonthlyInterstToBalance() {

		//arrange
		double rate=12;
		double updatedBalance= balance+ balance*rate/1200;
		
		//act
		account.creditInterest(rate);		
		
		
		//assert
		assertEquals(updatedBalance, account.getBalance(),0.2);  //balance shouldn't change after crediting interest 
		
		
	}


	

}
