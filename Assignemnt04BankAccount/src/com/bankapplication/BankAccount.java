
package com.bankapplication;

import java.util.Scanner;

import com.bankapplication.operations.Operations;

public class BankAccount {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int customerChoice;
		boolean quit = false;
		do {
			System.out.println("1. Create New Account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Credit Interest");
			System.out.println("5. exit");
			System.out.println("Enter your choice");
			customerChoice = userInput.nextInt();
			switch (customerChoice) {
			case 1:
				Operations.createAccount();
				break;
			case 2:
				Operations.depositMoney();
				break;
			case 3:
				Operations.withdrawMoney();
				break;
			case 4:
				Operations.calculateInterest();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Choose valid option");

			}
		} while (!quit);
	}

}
