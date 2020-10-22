package in.conceptarchitect.banking.app;

import in.conceptarchitect.banking.BankAccount;
import in.conceptarchitect.utils.Input;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//menuDrivenProgram();
		
		/*BankAccount a1=new BankAccount("Vivek","p@ss", 10000,10);
		
		BankAccount a2= new BankAccount("Vivek","hello", 10000,10);
		
		System.out.println("Interest rate for a1\t"+a1.getInterestRate());
		System.out.println("Interest rate for a2\t"+a2.getInterestRate());
		
		//it appears to change rate only for object "a1"
		// it is actually changing rate for everyone
		// Bad code! Unreadable
		a1.setInterestRate(12); //unclear code
		
		//Logically clear code
		BankAccount.setInterestRate(12); //Oh! its changing for everone
		
		System.out.println("Interest rate for a1\t"+a1.getInterestRate());
		System.out.println("Interest rate for a2\t"+a2.getInterestRate());
		
		
		
		
		
		
		
	}*/
		BankAccount a1=new BankAccount("Vivek","p@ss",20000,12);

		
		//a1.createAccount(1, "Vivek","p@ss",20000,12); //no need to call this line
		
		int choice=0;
		Input input=new Input();
		do {
			
			choice=input.readInt("1. show");
		
			switch(choice) {
//		case 1:
//				a1.deposit();
//				break;
//			case 2:
//				a1.withdraw();
//				break;
				
//			case 3:
//				a1.creditInterest();
//				break;
//				
			case 1:
				a1.show();
				break;
//			case 0:
//				break;
//			default:
//				System.out.println("Invalid Input.Retry");
//				
//				
			}
//			
//			System.out.println("\n\n");
//			
}while(choice!=0);
	}

}
