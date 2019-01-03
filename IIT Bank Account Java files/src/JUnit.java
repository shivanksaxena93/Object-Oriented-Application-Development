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
