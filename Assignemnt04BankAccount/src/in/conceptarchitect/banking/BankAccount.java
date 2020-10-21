package in.conceptarchitect.banking;

import java.util.Scanner;

public class BankAccount {

	static Scanner customerInput = new Scanner(System.in);
	public String name;
	public int accountNumber;
	public double balance;
	public String password;
	public double interest;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public BankAccount(int accountNumber, String name, String password, double amount, double rate) {
		createAccount(accountNumber, name, password, amount, rate);
	}

	private void createAccount(int accountNumber, String name, String password, double amount, double rate) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.password = password;
		this.balance = amount;
		this.interest = rate;
	}

	/* Method to show the BankAccount details */
	public void show() {
		System.out.println("Account Number\t" + this.accountNumber);
		System.out.println("Name\t" + name);
		System.out.println("Password\t" + password);
		System.out.println("Balance\t" + balance);
		System.out.println("Interest Rate\t" + interest);
	}

	// function to deposit money
	public void depositMoney(int accNo, String password) {
		if (this.password.equals(password)) {
			float depositingAmount;
			System.out.print("Enter Amount to deposit:");
			depositingAmount = customerInput.nextFloat();
			this.balance += depositingAmount;
			if (depositingAmount <= 0) {
				System.out.println("Negative amount cannnot be deposited, Please enter valid amount");
			} else {
				System.out.println("Amount deposited Succesfully and Available balance is :" + this.balance);
			}
		} else {
			System.out.println("Invalid Credentials");
		}
	}

	// function to withdraw money
	public void withdrawMoney(int accNo, String password) {
		if (this.password.equals(password)) {
			System.out.print("Enter Amount to withdraw: ");
			float Withdrawamount = customerInput.nextFloat();
			this.balance -= Withdrawamount;
			if (Withdrawamount <= 0 || Withdrawamount > this.balance) {
				System.out.println("Insufficient balance in your account or please enter valid amount");
			} else {
				System.out.println("Amount Withdrawen Succesfully available balance is :" + this.balance);
			}
		} else {
			System.out.println("Invalid Credentials");

		}
	}

	// function to calculate interest
	public void calculateInterest(int accNo, String password) {
		if (this.password.equals(password)) {
			System.out.print("Enter interest rate ");
			double interestRate = customerInput.nextFloat();
			double accountBalance = (this.balance * interestRate) / 1200;
			System.out.println("Calculated Interest is" + accountBalance);
		} else {
			System.out.println("Invalid Credentials");
		}
	}

	// function to update password
	public void updatePassword(int accNo) {
		System.out.println("Enter password to update");
		String updatePassword = customerInput.next();
		this.password = updatePassword;
		System.out.println("Passwpord Updated succesfully");

	}

}
