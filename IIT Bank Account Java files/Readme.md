# PROJECT – 1 Program to simulate Bank Account

## Objective: To design a code for operating Bank Account and its Transactions.

## PROJECT CODE

## 1)	AccountHolder.java

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
	
## 2)	AccountHolderTest.java

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
/**
 * 
 * @author Shivank
 *@version 1.5
 *@since 2017/09/13
 */
public class AccountHolderTest {
	private static boolean success = false;
	private static double initBalance;
	private static double depositAmount;
	private static double withdrawalAmount;
	private static double interestRate;
	private static int month = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Intital Balance");
		initBalance = sc.nextDouble();
		AccountHolder shivankAccount = new AccountHolder(initBalance);
		System.out.println(" Enter deposit amount");
		depositAmount = sc.nextDouble();
		shivankAccount.deposit(depositAmount);
		System.out.println(" Enter Withdrawal Amount ");
		do{
			
			withdrawalAmount = sc.nextDouble();
			success = shivankAccount.withdrawal(withdrawalAmount);
		}while(!success);

		System.out.println(" Enter the Intial Interest Rate");
		interestRate = sc.nextDouble();
		shivankAccount.setAnnualInterestRate(interestRate);
		
		System.out.println("Monthly balance for one year at 0.04");
		System.out.println(" Balances:");
		System.out.println("Account Balance w. Interest");
		System.out.println(" Base " + shivankAccount.getBalance());
		while(month <=12){
			shivankAccount.monthlyInterest();
			System.out.println("Month"+month+":  " + shivankAccount.toString()+ "\n");
			month++;
		}
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Curr dt=" + timeStamp + "\nProgrammed by Shivank Saxena ");
		System.out.println(" Enter the New Interest Rate");
		interestRate = sc.nextDouble();	
		shivankAccount.modifyMonthlyInterest(interestRate);
		shivankAccount.monthlyInterest();
		System.out.println("After setting interest rate to 0.05 and calculating monthly interest rate");
		System.out.println("Balances:");
		System.out.println("Account Balance with interest");
		System.out.println(shivankAccount.toString());
		//String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("Curr dt=" + timeStamp + "\nProgrammed by Shivank Saxena ");
	}
}

## 3)	JUnit.java

import static org.junit.Assert.*;

import org.junit.Test;
/**
* 
* @author Shivank
*@version 1.3
*@since 2017/09/15
*/
public class JUnit {
AccountHolder shivankAccount = new AccountHolder (1);

	@Test
	public void testBalance () {
//test if data balance member is positive
		assertTrue (shivankAccount.getBalance () > 0);
	}
	
	@Test
	public void testInitialInterest () {
		//test start value for interest
		//AccountHolder.getAnnualInterestRate();
		double val = AccountHolder.getAnnualInterestRate();
		assertTrue ( val ==0);
	}
	@Test
	public void testModifyInterest() {
			//test Interest rate range (between 0 &&1)
			AccountHolder.modifyMonthlyInterest(.5);
			double val = AccountHolder.getAnnualInterestRate();
			assertTrue (val>0);
		}
	@Test
	public void testannualInterestNotNUlln() {
		double val = AccountHolder.getAnnualInterestRate ();
		assertNotNull (val) ;
	}
		
}


## RESULTS:
### Entering the initial balance
![Entering the initial balance](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/1%20-%20Entering%20the%20Initial%20Balance.PNG)

### Final balance including the add on amount
![Final balance including the add on amount](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/2%20-%20Final%20Balance%20including%20the%20add%20on%20amount.PNG)

### Entering the withdrawal balance
![Entering the withdrawal balance](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/3%20-%20Withdrawl%20Balance.PNG)

### Entering initial interest Rate of 4% and capturing revised balances
![Entering initial interest Rate of 4% and capturing revised balances](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/4%20-%20Entering%20Initial%20Interest%20Rate%20with%20Revised%20Balance.PNG)

### Modifying the interest rate to 5% and capturing new balance
![Modifying the interest rate to 5% and capturing new balance](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/5%20-%20Modifying%20the%20Interest%20Rate%20and%20Capturing%20new%20Rate.PNG)

### Amount less than 500 will charge $50 as a transaction fees
![Amount less than 500 will charge $50 as a transaction fees](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/6%20-%20Amount%20Less%20than%20500%20will%20charge%20%2450%20as%20a%20transaction%20fees.PNG)

### Failing of transaction while balance goes below $100
![Failing of transaction while balance goes below $100](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/7%20-%20Failing%20of%20Transaction%20while%20balance%20goes%20below%20%24100.PNG)

### Reattempting to enter new amount and more thn 2 transation it fails take any more attempts
![Reattempting to enter new amount and more thn 2 transation it fails take any more attempts](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/8%20-%20Reattempting%20to%20enter%20new%20amount%20and%20more%20thn%202%20transation%20it%20fails%20take%20any%20more%20attempts.PNG)

### JTEST OUPUT:
![JTEST OUPUT](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/IIT%20Bank%20Account%20Java%20files/Images/9%20-%20JTest%20output.PNG)
 
