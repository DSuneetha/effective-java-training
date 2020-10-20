package com.bankapplication.operations;

import java.util.Scanner;

import com.bankapplication.model.BankAccountModel;

public class Operations {
	static Scanner customerInput = new Scanner(System.in);
	static BankAccountModel bankAccountModel = new BankAccountModel();

	// function to create Account
	public static void createAccount() {
		System.out.println("Enter Name");
		String name = customerInput.next();
		bankAccountModel.setName(name);
		System.out.println("Enter AccountNumber");
		int number = customerInput.nextInt();
		bankAccountModel.setAccountNumber(number);
		System.out.println("Enter Password");
		String password = customerInput.next();
		bankAccountModel.setPassword(password);
		System.out.println("Enter Balance");
		float balance = customerInput.nextFloat();
		bankAccountModel.setBalance(balance);
		System.out.println("Enter Interest rate");
		float interestRate = customerInput.nextFloat();
		bankAccountModel.setInterest(interestRate);
		System.out.println("Account created successfully with" + "\n" + "Name:" + bankAccountModel.getName() + "\n"
				+ "Password:" + bankAccountModel.getPassword() + "\n" + "AccountNumber:"
				+ bankAccountModel.getAccountNumber() + "\n" + "Balance:" + bankAccountModel.getBalance() + "\n"
				+ "Interest Rate:" + bankAccountModel.getInterest());
	}

	// function to deposit money
	public static void depositMoney() {
		System.out.println("Enter Account Number");
		int number = customerInput.nextInt();
		float depositingAmount;
		float accountBalance = bankAccountModel.getBalance();
		System.out.print("Enter Amount to deposit:");
		depositingAmount = customerInput.nextFloat();
		accountBalance += depositingAmount;
		if (depositingAmount <= 0) {
			System.out.println("Negative amount cannnot be deposited, Please enter valid amount");
		} else {
			System.out.println("Amount deposited Succesfully and Available balance is :" + accountBalance);
		}
	}

	// function to withdraw money
	public static void withdrawMoney() {
		float Withdrawamount;
		System.out.println("Enter Account Number");
		int number = customerInput.nextInt();
		float accountBalance = bankAccountModel.getBalance();
		System.out.print("Enter Amount to withdraw: ");
		Withdrawamount = customerInput.nextFloat();
		accountBalance -= Withdrawamount;
		if (Withdrawamount <= 0 || Withdrawamount > accountBalance) {
			System.out.println("Insufficient balance in your account or please enter valid amount");
		} else {
			System.out.println("Amount Withdrawen Succesfully available balance is :" + accountBalance);
		}
	}

	// function to calculate interest
	public static void calculateInterest() {
		System.out.println("Enter Account Number");
		int number = customerInput.nextInt();
		float accountBalance = bankAccountModel.getBalance();
		System.out.print("Enter interest rate ");
		float interestRate = customerInput.nextFloat();
		accountBalance = accountBalance * interestRate / 1200;
		System.out.println("Calculated Interest is" + accountBalance);

	}
}
