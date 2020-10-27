package in.conceptarchitect.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.banking.SavingsAccount;
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
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		boolean result = bank.transfer(123, 500, "suni", targetAccountNumber);
		if(result)
			fail("Invalid source Account");
	}
	
	@Test
	public void transfer_shouldFailIfInvalidToAccount() {
		boolean result = bank.transfer(srcAccountNumber, 500, "suni", 123);
		if(result)
			fail("Invalid target Account");
	}
	
	@Test
	public void transfer_shouldFailForInvalidPassword() {
		boolean result = bank.transfer(srcAccountNumber, 500, "abc", targetAccountNumber);
		if(result)
			fail("Invalid password");
	}
	
	@Test
	public void transfer_shouldFailForInsufficientBalance() {
		boolean result = bank.transfer(srcAccountNumber, 50000, "suni", targetAccountNumber);
		if(result)
			fail("Invalid Balance");
	}
	
	@Test
	public void transfer_shouldSucceedInHappyPath() {
		boolean result = bank.transfer(srcAccountNumber, 500, "suni", targetAccountNumber);
		if(result)
			assertEquals(true, result);
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
	public void closeAccount_failsForInvalidAccountNumber() {
		boolean result = false;
		BankAccount account=bank.getAccount(5,"suni");
		if(account != null)
			result = bank.close(5, "suni");
		if(result)
			fail("Invalid Account Number");
	}   
	
	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() {
		
		int accountNumber = bank.openAccount("savings", "karthik", "karthik", 2000);
		bank.close(accountNumber, "suni");
		boolean result = bank.withdraw(accountNumber, 500, "karthik");
		if(result)
			fail("account already closed");
	}
	
	@Test
	public void openAccount_withSavingsTypeCreatesASavingAccount() {
		
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
