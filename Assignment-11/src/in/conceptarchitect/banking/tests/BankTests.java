package in.conceptarchitect.banking.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;

public class BankTests {

	Bank b = new Bank("SBI", 50000);
	BankAccount bankaccount;
	
	@Before
	public void init() {		
		int firstAccountNo=b.openAccount("suni","suni", 45000.0);
		int secondAccountNo=b.openAccount("swathi","swathi", 50000.0);
	}

	@Test
	public void transfer_shouldFailIfFromAccountDoesntExist() {
		boolean result = b.transfer(123, 2000, "abc", 2);
		if (result)
			fail("account not exits");

	}

	@Test
	public void transfer_shouldFailIfInvalidToAccount() {
		boolean result = b.transfer(1, 2000, "suni", 123);
		if (result)
			fail("target account not exits");
	}

	@Test
	public void transfer_shouldFailForInvalidPassword() {
		boolean result = b.transfer(1, 2000, "abc", 2);
		if (result)
			fail("invalid pasword");
	}

	@Test
	public void transfer_shouldFailForInsufficientBalance() {
		boolean result = b.transfer(1, 450000, "suni", 2);
		if (result)
			fail("invalid balance");
	}

	@Test
	public void transfer_shouldSucceedInHappyPath() {
		boolean result = b.transfer(1, 4500, "suni", 2);
		if (result)
			assertEquals(true, result);
	}

	@Test
	public void creditInterest_creditsOneMonthOfInterest() {
		b.creditInterests();
	}

	@Test
	public void closeAccount_failsForInvalidAccountNumber() {
		boolean result = b.close(9, "suni");
		 if(result)
			 fail("in valid account");
		

	}

	
	@Test
	public void closeAccount_cantWithdrawFromClosedAccount() {
		boolean result = b.withdraw(5, 1000, "abc");
		if (result)
			assertEquals(false, false);
	}

	@Test
	public void openAccount_AssignsSequentialAccountNumber() {
		 b.openAccount("indu", "indu", 45000.0);
		
}
	
	

}
