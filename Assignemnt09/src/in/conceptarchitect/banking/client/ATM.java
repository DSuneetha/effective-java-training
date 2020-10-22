package in.conceptarchitect.banking.client;

import java.util.Scanner;

import in.conceptarchitect.banking.Bank;
import in.conceptarchitect.banking.BankAccount;

import in.conceptarchitect.utils.Input;

public class ATM {
	
	
	Bank bank=new Bank("SBI",8) ;
	Input keyboard=new Input();
	BankAccount bankAccount;
	private int accountNumber;
	Scanner input= new Scanner(System.in);
	public void connectTo(Bank bank) {
		// TODO Auto-generated method stub
		this.bank=bank;
	}
	
	
	public void start() {
		
		displayWelcomeScreen();		
		
	}


	public void displayWelcomeScreen() {
		// TODO Auto-generated method stub
		while(true) {
			accountNumber=keyboard.readInt("accountNumber?");
			if(accountNumber==-999) {		//hidden admin menu
				if(keyboard.readString("error:").equals("NIMDA"))
					if(displayAdminMenu().equals("QUIT"))
						return;
			}else
				displayUserMenu();
		
		}
	}


	private void displayUserMenu() {
		// TODO Auto-generated method stub
		System.out.println("Welcome "+accountNumber);
		
		int choice;
		do {
			choice=keyboard.readInt("1. Deposit  2. Widthraw  3. Transfer  4. Show 5. Close Account  0. Exit: ");
			switch(choice) {
			case 1:
				doDeposit(); break;
			case 2:
				doWithdraw(); break;
			case 3:
				doTransfer(); break;
			case 4:
				doShow(); break;
			case 5:
				doCloseAccount(); break;
			case 0: break;
			default:
				System.out.println("invalid input. retry");
				
			}
			System.out.println();
		}while(choice==0);
		
		
	}


	private void doCloseAccount() {
		System.out.println("Enter account number");
		int accountNumber = input.nextInt();
		System.out.println("Enter password");
		String password = input.next();
		bank.close(accountNumber, password);
		
	}


	private void doShow() {
		System.out.println("Enter account number");
		int accountNumber = input.nextInt();
		bank.show(accountNumber);
		
	}


	private void doTransfer() {
		System.out.println("Enter sourceaccount number");
		int sourceAccountNumber = input.nextInt();
		System.out.println("Enter targetAccount number");
		int targetAccountNumber = input.nextInt();
		System.out.println("Enter amount");
		int amount = input.nextInt();
		System.out.println("Enter password");
		String password = input.next();
		bank.transfer(sourceAccountNumber, amount, password, targetAccountNumber);
	}


	private void doWithdraw() {
		System.out.println("Enter account number");
		int accountNumber = input.nextInt();
		System.out.println("Enter password");
		String password = input.next();
		System.out.println("Enter amount to withdraw");
		int amount = input.nextInt();
		bank.withdraw(accountNumber, amount,password);
		System.out.println("Amount withdrawed successfully");

	}


	private void doDeposit() {
		System.out.println("Enter account number");
		int accountNumber = input.nextInt();
		System.out.println("Enter amount to deposit");
		int amount = input.nextInt();
		bank.deposit(accountNumber, amount);
		System.out.println("Amount deposited successfully");
		
	}


	private String displayAdminMenu() {
		// TODO Auto-generated method stub
		int choice;
		do {
			choice=keyboard.readInt("1. Open Account  2. Credit Interest  3. Print Accounts  4. Shutdown  0. Exit: ");
			switch(choice) {
			case 1:
				doOpenAccount(); break;
			case 2:
				doCreditInterest(); break;
			case 3:
				doPrintAccounts(); break;
			case 4:
				return "QUIT";
			case 0: break;
			default:
				System.out.println("invalid input. retry");
				
			}
			System.out.println();
		}while(choice==0);
		return "";
	}


	private void doPrintAccounts() {
		bank.printAccountList();
	}


	private void doCreditInterest() {
		bank.creditInterests();
	}


	private void doOpenAccount() {
		System.out.println("Enter name");
		String name = input.next();
		System.out.println("Enter password");
		String password = input.next();
		System.out.println("Enter amount");
		double amount = input.nextDouble();
		bank.openAccount(name, password, amount);
		System.out.println("Account created successfully");
		
	}	
	
	
	
	
	
}
