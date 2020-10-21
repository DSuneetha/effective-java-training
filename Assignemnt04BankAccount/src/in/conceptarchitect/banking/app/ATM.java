
package in.conceptarchitect.banking.app;

import java.util.Scanner;

import in.conceptarchitect.banking.BankAccount;

public class ATM {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		BankAccount bankAccount = null;
		int customerChoice;
		String name;
		int accountNo;
		String password;
		boolean quit = false;
		do {
			System.out.println("1. Create New Account");
			System.out.println("2. Deposit Money");
			System.out.println("3. Withdraw Money");
			System.out.println("4. Credit Interest");
			System.out.println("5. Update Password");
			System.out.println("6. show");
			System.out.println("7. exit");
			System.out.println("Enter your choice");
			customerChoice = userInput.nextInt();
			switch (customerChoice) {
			case 1:
				System.out.println("Please enter account number");
				accountNo = userInput.nextInt();
				System.out.println("Please enter name");
				name = userInput.next();
				System.out.println("Please enter password");
				password = userInput.next();
				System.out.println("Please enter initial deposits");
				int balance = userInput.nextInt();
				System.out.println("Please enter rate of interest");
				double rate = userInput.nextDouble();
				System.out.println("Account created successfully");
				bankAccount = new BankAccount(accountNo, name, password, balance, rate);
				break;
			case 2:
				System.out.println("Please enter account number");
				accountNo = userInput.nextInt();
				System.out.println("Please enter password");
				password = userInput.next();
				bankAccount.depositMoney(accountNo, password);
				break;
			case 3:
				System.out.println("Please enter account number");
				accountNo = userInput.nextInt();
				System.out.println("Please enter password");
				password = userInput.next();
				bankAccount.withdrawMoney(accountNo, password);
				break;
			case 4:
				System.out.println("Please enter account number");
				accountNo = userInput.nextInt();
				System.out.println("Please enter password");
				password = userInput.next();
				bankAccount.calculateInterest(accountNo, password);
				break;
			case 5:
				System.out.println("Please enter account number");
				accountNo = userInput.nextInt();
				bankAccount.updatePassword(accountNo);
				break;
			case 6:
				bankAccount.show();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("Choose valid option");

			}
		} while (!quit);
	}

}
