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
