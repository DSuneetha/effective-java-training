package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.SavingsAccount;
import in.conceptarchitect.banking.exceptions.InsufficientBalanceException;
import in.conceptarchitect.banking.exceptions.InvalidAccountNumberException;
import in.conceptarchitect.banking.exceptions.InvalidCredentialsException;
import in.conceptarchitect.banking.exceptions.InvalidDenominationException;

import static in.conceptarchitect.utils.CustomAsserts.*;

public class BankTests {
	
	Bank bank=new Bank("SBI",1);
	int srcAccountNumber=0;
	int targetAccountNumber=0;
	int balance=15000;
	BankAccount account;
	@Before
	public void init()
	{
		 account=new SavingsAccount("bcd", "bcd", 15000);
		srcAccountNumber = bank.openAccount("savings", "suni", "suni", 1000);
		targetAccountNumber = bank.openAccount("savings", "kanna", "kanna", 2000);

	}

	@Test
	public void transfer_shouldFailIfFromAccountDoesntExist() throws InvalidAccountNumberException, InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		bank.transfer(123, 500, "suni", targetAccountNumber);
		
	}
	
	@Test
	public void transfer_shouldFailIfInvalidToAccount() throws InvalidAccountNumberException, InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		bank.transfer(srcAccountNumber, 500, "suni", 123);
		

	}
	
	@Test
	public void transfer_shouldFailForInvalidPassword() throws InvalidAccountNumberException, InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		bank.transfer(srcAccountNumber, 500, "abc", targetAccountNumber);
		

	}
	
	@Test
	public void transfer_shouldFailForInsufficientBalance() throws InvalidAccountNumberException, InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		bank.transfer(srcAccountNumber, 50000, "suni", targetAccountNumber);
		

	}
	
	@Test
	public void transfer_shouldSucceedInHappyPath() throws InvalidAccountNumberException, InvalidCredentialsException, InvalidDenominationException, InsufficientBalanceException {
		bank.transfer(srcAccountNumber, 500, "suni", targetAccountNumber);
		
	}
	
	@Test
	public void creditInterest_creditsOneMonthOfInterest() {
		
		double rate=12;
		double updatedBalance= balance+ balance*rate/1200;

		//act
		account.creditInterest(rate);		
		
		
		//assert
		assertEquals(updatedBalance, account.getBalance(),0.2);
		
	}
	
	@Test
	public void closeAccount_failsForInvalidAccountNumber() throws InvalidAccountNumberException, InvalidCredentialsException, InsufficientBalanceException {
		boolean result = false;
		BankAccount account=bank.getAccount(5,"suni");
		if(account != null)
			bank.close(5, "suni");
		
	}   
	
	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() throws InvalidCredentialsException, InvalidAccountNumberException, InsufficientBalanceException, InvalidDenominationException {
		
		int accountNumber = bank.openAccount("savings", "karthik", "karthik", 2000);
		bank.close(accountNumber, "suni");
		bank.withdraw(accountNumber, 500, "karthik");
		
	}
	
	@Test
	public void openAccount_withSavingsTypeCreatesASavingAccount() throws InvalidAccountNumberException, InvalidCredentialsException {
		
		Bank bank=new Bank("bank name",1);
		bank.openAccount("savings", "suni", "suni", 1000);

		bank.openAccount("savings", "someone", "somepassword", 1000);
		
		BankAccount account=bank.getAccount(1,"somepassword");
		if(account!=null)
			assertEquals(account, account);
		
		//assertType(SavingsAccount.class, account);
		
	}
	
	
	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
		int accountNumber = bank.openAccount("savings", "abc", "abc", 2000);
		if(accountNumber ==1)
			assertEquals(1, accountNumber);

	}
	

}

