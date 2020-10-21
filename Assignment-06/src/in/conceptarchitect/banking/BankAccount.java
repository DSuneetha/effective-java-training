package in.conceptarchitect.banking;

import in.conceptarchitect.utils.Input;

public class BankAccount {

	int accountNumber;
	String name;
	String password;
	double balance;
	double interestRate;

	public int getAccountNumber() {
		return accountNumber;
	}

	// you can't change your account number
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// balance
	public double getBalance() {
		return balance;
	}

	// no set balance. to set balance use deposit or withdraw

	// get set interest rate
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BankAccount(int accountNumber, String name, String password, double amount, double rate) {
		createAccount(accountNumber, name, password, amount, rate);
	}

	// I don't want anyone else calling this function
	private void createAccount(int accountNumber, String name, String password, double amount, double rate) {
		this.accountNumber = accountNumber;
		this.name = name; // this.name is class field, name is argument
		this.password = password;
		this.balance = amount; // this is not required as balance has no conflict
		interestRate = rate; // this is not required
	}

	public void deposit() {
		Input input = new Input();
		if (this.password.equals(password)) {
			int amount = input.readInt("amount to deposit?");
			if (amount > 0) {
				balance += amount;
				System.out.println("Amount deposited successfully");
			} else {
				System.out.println("Invalid Amount. Deposit Failed");
			}
		} else {
			System.out.println("invalid credentials");
		}

	}

	public void withdraw() {
		Input input = new Input();
		int amount = input.readInt("amount to withdraw?");
		String password = input.readString("password");
		if (!this.password.equals(password)) {
			System.out.println("invalid credentials");
			return;
		} else if (amount <= 0) {
			System.out.println("invalid denomination. please enter positive amount");
		} else if (amount > balance) {
			System.out.println("Insufficient Funds");
		} else {
			balance -= amount;
			System.out.println("please collect your cash");
		}
	}

	public void creditInterest() {
		// TODO Auto-generated method stub
		balance += (balance * interestRate) / 1200; // one month interest at a time.
	}

	public void show() {
		System.out.println("Account Number\t" + this.accountNumber);// this is not required
		System.out.println("Name\t" + name); // this is not required
		System.out.println("Password\t" + password); // this is not required
		System.out.println("Balance\t" + balance); // this is not required
		System.out.println("Interest Rate\t" + interestRate); // this is not required
	}

}
