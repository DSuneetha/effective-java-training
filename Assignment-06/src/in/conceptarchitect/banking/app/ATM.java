package in.conceptarchitect.banking.app;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.utils.Input;

public class ATM {

	public static void main(String[] args) {
		BankAccount a1 = new BankAccount(1, "Vivek", "p@ss", 20000, 12);
		int choice = 0;
		Input input = new Input();
		do {
			choice = input.readInt(
					"1. Deposit\n2. Withdraw\n3.Credit Interst\n4.Show\n" + "5.update Password\n0.Exit\nChoose:");
			switch (choice) {
			case 1:
				a1.deposit();
				break;
			case 2:
				a1.withdraw();
				break;

			case 3:
				a1.creditInterest();
				break;

			case 4:
				a1.show();
				break;
			case 5:
				String password = input.readString("Enter password you want to update");
				a1.setPassword(password);
				System.out.println("Password updated successfully");
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Input.Retry");

			}

			System.out.println("\n\n");

		} while (choice != 0);

	}

}
