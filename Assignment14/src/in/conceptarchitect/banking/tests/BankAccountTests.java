package in.conceptarchitect.banking.tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;
import in.conceptarchitect.banking.exceptions.InvalidDenominationException;

public class BankAccountTests {
	
	
	//ARRANGE
	BankAccount account;
	String name="Vivek";
	String correctPassword="password";
	double balance=20000;
	
	@Before   //this will be called before every test
	public void init() {
		
		account=new BankAccount(name,correctPassword, balance);
	}

	
	
	
	@Test
	public void withdraw_shouldSucceedForHappyPath() throws InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException  {		
		
		
		account.withdraw(1, correctPassword); //should be successful		
		
		//what do I assert on
		
		assertEquals(balance-1, account.getBalance(),0);
		
	}
	
	
	
	@Test
	public void withdraw_shouldThrowInvalidCredentialsExceptionForWrongPassword() throws InvalidDenominationException, InsufficientBalanceException {
		//ACT
		try {
			account.withdraw(balance,"wrong-password");  //should throw InvalidCredentialsException
			//Oh! exceptected exception didn't occur. Its a failure
			fail("Didn't throw InvalidCredentialsException");
		
		} catch(InvalidCredentialsException ex) {
			//success. do nothing
		}
		
	}
	
	
	
	
	@Test(expected = InsufficientBalanceException.class)
	public void withdraw_shouldFailForInsufficientBalance() throws InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {

		account.withdraw(balance+1, correctPassword);		
		
	}
	
	

}
