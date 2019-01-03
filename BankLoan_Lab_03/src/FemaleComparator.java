

import java.util.*;
/**
 * 
 * @author Shivank
 *This class sorts the records in the file bank-details based on the sex 
 */

public  class FemaleComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords o0, BankRecords o1) {
		// TODO Auto-generated method stub
		
		int result =o0.getSex().compareTo(o1.getSex());
		return result;
	}
}
