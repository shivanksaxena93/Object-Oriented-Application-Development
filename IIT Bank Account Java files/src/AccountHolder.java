/**
 * 
 * @author Shivank
 *@version 1.3
 *@since 2017/09/13
 */
public class AccountHolder {
	private static double annualInterestRate;
	private double balance = 0;
	
	
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public static void setAnnualInterestRate(double annualInterestRate) {
		if (annualInterestRate>= 0 && annualInterestRate <= 1) {
			
		AccountHolder.annualInterestRate = annualInterestRate;
		}
		else {
			System.out.println(" The Interest can be between 0 and 1 only");
			System.exit(0);
		}
	}
	public AccountHolder(double initBalance) {
		if ( initBalance < 0) {
			System.out.println("Initial Balance Cannot be Negative");
			System.exit(0);
		} else
		{
			balance = initBalance;
		}
	}
	
	public void monthlyInterest() {
		balance += balance*(annualInterestRate / 12.0);
	}
	public static void modifyMonthlyInterest (double rateUpdate) {
		if (rateUpdate >= 0 && rateUpdate <= 1) {
			annualInterestRate = rateUpdate;
			System.out.println("New Ineterst rate is: " + annualInterestRate);
		}
		else {
			System.out.println("Invalid Rate");
			System.exit(0);
		}
	}
	public void deposit (double amount) {
		if (amount < 0) {
		System.out.println("Error deposit amount cannot be negative");
		System.exit(0);
		}
		else {
			balance +=amount;
			System.out.println("New Balance is: $"+ balance);
			
		}
		
		
	}
	public boolean withdrawal(double amount) {
		 if(balance-amount <100) {
			System.out.println("Insufficient Balance to carry out this transcation. You have to maintian a Minimumum balance for the transaction ");
			System.out.println("Enter the new Withdrawal Amount");
			return false;
		 	}else if(balance - amount <500){
		 		if(balance-amount - 50 < 100) {
		 			System.out.println("Insufficient Balance to carry out this transcation.You cannot withdraw! ");
		 			System.exit(0);
		 			return true;
		 		}else {
		 			balance = balance - amount - 50;
			 		System.out.println("New Balance is: $"+ balance);
			 		return true;
		 		}
		 		
		 	}else {
		 		balance = balance - amount;
		 		System.out.println("New Balance is: $"+ balance);
		 		return true;
		 	}
		 	
		}
	
		public String toString() {
			return String.format("$%.2f", balance);
		}
	}

