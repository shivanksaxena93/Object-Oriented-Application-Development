import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @author Shivank
 * The class reads files from a file bank_details performs few analysis and then stores the results of the analysis into a file bankrecords
 */
public class Records extends BankRecords {
	public static FileWriter fw = null;

	public Records(){
		try {
			BankRecords br = new BankRecords();
			br.readData();
			br.processData();
			fw = new FileWriter("bankrecords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String toString(double val) {
		return String.format("%.2f", val );
	}

	/* Main Start of the Program */
	
	public static void main(String[] args) {
		Records record = new Records();
		record.readData();
		record.processData();			
		
		avgMinMaxComparator();
		femaleComparator();
		maleComparator();
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
		.format(Calendar.getInstance().getTime());
		System.out.println("\nDated on :" + timeStamp+ "\nProgrammed by Shivank\n");
		try{
			fw.write(String.format("\r\n"));
			fw.write(String.format("\r\nDated on :" + timeStamp+ "\r\nProgrammed by Shivank\r\n"));
			}catch(IOException e){
			e.printStackTrace();
		}

		
		try {
			fw.close(); //Flush Statements to the file 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}
	
	/* This program finds the Average, MAximum and Mininum of the Income of different areas */
	public static void avgMinMaxComparator() {
		
		double cityMaxIncome = 0;
		double cityMinIncome = 0;
		double ruralMaxIncome = 0;
		double ruralMinIncome = 0;
		double townMinIncome = 0;
		double townMaxIncome = 0;
		double suburbanMaxIncome = 0;
		double suburbanMinIncome = 0;
		double cityIncomeSum=0; 
		double ruralIncomeSum =0, townIncomeSum=0, suburbanIncomeSum=0;
		int Countofcity=0, Countofrural = 0, Countoftown = 0, Countofsuburban = 0;
		
	
		for (int i = 0; i < bankRecords.length - 1; i++){
			if(bankRecords[i].getRegion().equals("INNER_CITY")) {
				cityIncomeSum += bankRecords[i].getIncome();
				Countofcity++;
				if(Countofcity == 1 || bankRecords[i].getIncome() < cityMinIncome) {
					cityMinIncome = bankRecords[i].getIncome();
				}
				if(bankRecords[i].getIncome()>cityMaxIncome) {
					cityMaxIncome = bankRecords[i].getIncome();
				}
				
			}
			
			if(bankRecords[i].getRegion().equals("RURAL")){
				ruralIncomeSum += bankRecords[i].getIncome();
				Countofrural++;
				if(Countofrural == 1 || bankRecords[i].getIncome()< ruralMinIncome) {
					ruralMinIncome = bankRecords[i].getIncome();
				}
				if(bankRecords[i].getIncome()>ruralMaxIncome) {
					ruralMaxIncome = bankRecords[i].getIncome();
				}

			}
			if(bankRecords[i].getRegion().equals("TOWN"))
			{
				townIncomeSum +=bankRecords[i].getIncome();
				Countoftown++;
				if(Countoftown == 1 || bankRecords[i].getIncome()<townMinIncome) {
					townMinIncome = bankRecords[i].getIncome();
				}
				if(bankRecords[i].getIncome()>townMaxIncome) {
					townMaxIncome = bankRecords[i].getIncome();
				}
				
			}
			if(bankRecords[i].getRegion().equals("SUBURBAN")){
				suburbanIncomeSum += bankRecords[i].getIncome();
				Countofsuburban++;
				if(Countofsuburban == 1 || bankRecords[i].getIncome() < suburbanMinIncome) {
					suburbanMinIncome = bankRecords[i].getIncome();
				}
				if(bankRecords[i].getIncome()>suburbanMaxIncome) {
					suburbanMaxIncome = bankRecords[i].getIncome();
				}
			
			}
		}
		
		System.out.println("City's Average Income: "+toString(cityIncomeSum/Countofcity));
		System.out.println("Town's Average Income : "+toString(townIncomeSum/Countoftown));
		System.out.println("Suburb's Average Income :"+toString(suburbanIncomeSum/Countofsuburban));
		System.out.println("Rural's Average Income : "+toString(ruralIncomeSum/Countofrural));
		
		System.out.println("\nCity's Max Income : "+toString(cityMaxIncome));
		System.out.println("Town's Max Income : "+toString(townMaxIncome));
		System.out.println("Suburb's Max Income :"+toString(suburbanMaxIncome));
		System.out.println("Rural's Max Income : "+toString(ruralMaxIncome));
		
		System.out.println("\nCity's Min Income : "+toString(cityMinIncome));
		System.out.println("Town's Min Income : "+toString(townMinIncome));
		System.out.println("Suburb's Min Income : "+toString(suburbanMinIncome));
		System.out.println("Rural's Min Income  : "+toString(ruralMinIncome));
				

		try{
			fw.write(String.format("\r\nCity's Average Income :"+toString(cityIncomeSum/Countofcity)+"\r\nTown's Average Income :"+toString(townIncomeSum/Countoftown)+"\r\nSuburb's Average Income :"+(suburbanIncomeSum/Countofsuburban)+"\r\nRural's Average Income :"+(ruralIncomeSum/Countofrural)));
			fw.write(String.format("\r\n\r\nCity's Max Income :"+toString(cityMaxIncome)+"\r\nTown's Max Income :"+townMaxIncome+"\r\nSuburb's Max Income :"+toString(suburbanMaxIncome)+"\r\nRural's Max Income :"+toString(ruralMaxIncome)));
			fw.write(String.format("\r\n\r\nCity's Min Income :"+toString(cityMinIncome)+"\r\nTown's Min Income :"+townMinIncome+"\r\nSuburb's Min Income :"+toString(suburbanMinIncome)+"\r\nRural's Min Income :"+toString(ruralMinIncome)));
			
}catch(IOException e){
			e.printStackTrace();
		}		
	}

	/**
	 * 
	 * This method displays and writes into the file bankrecord.txt number of females with both a mortgage and savings account per location
	 */

		public static void femaleComparator() {
		Arrays.sort(bankRecords, new FemaleComparator());
		int innerCityFemaleCount = 0, ruralFemaleCount = 0, suburbanFemaleCount = 0, townFemaleCount = 0;
			
		for (int i = 0; i < bankRecords.length; i++) {
			if(bankRecords[i].getSex().equals("FEMALE") && (bankRecords[i].getMortgage().equals("YES"))  && (bankRecords[i].getSave_act().equals("YES")) ) {
				if(bankRecords[i].getRegion().equals("INNER_CITY")) {
					innerCityFemaleCount++;
				}
				
				else if(bankRecords[i].getRegion().equals("RURAL")) {
					ruralFemaleCount++;
				}
				else if(bankRecords[i].getRegion().equals("SUBURBAN")) {
					suburbanFemaleCount++;
				}
				else {
					townFemaleCount++;
				}
			}
		}
		
		System.out.println("\nmort & savings acct of females of Innercity region: " + (innerCityFemaleCount-1));
		System.out.println("mort & savings acct of females of Rural region: " + ruralFemaleCount);
		System.out.println("mort & savings acctof females of suburban region: " + suburbanFemaleCount);
		System.out.println("mort & savings acct of females of Town region: " + townFemaleCount);
		try {
			fw.write(String.format("\r\n\r\nInnercity region females with mort & savings acct: " + (innerCityFemaleCount-1) + "\r\n" +
					"Rural region females with mort & savings acct: " + ruralFemaleCount+"\r\n"+
					"suburban region females with mort & savings acct: " + suburbanFemaleCount+"\r\n"
					+"Town region females with mort & savings acct: " + townFemaleCount));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	/** 
	 * 
	 * This method displays and writes into the file bankrecord.txt number of males with both a car and 1 child per location
	 */
		public static void maleComparator() {
			
			//Arrays.sort(a, new MaleComparator());
			int innerCityMaleCount = 0, ruralMaleCount = 0, suburbanMaleCount = 0, townMaleCount = 0;
			for (int i = 0; i < bankRecords.length; i++){
				if(bankRecords[i].getCar().equals("YES") && (bankRecords[i].getChildren()== 1) && bankRecords[i].getSex().equals("MALE") ) {
					if(bankRecords[i].getRegion().equals("INNER_CITY")) {
						innerCityMaleCount++;
					}
					if(bankRecords[i].getRegion().equals("RURAL")) {
						ruralMaleCount++;
					}
					if(bankRecords[i].getRegion().equals("SUBURBAN")) {
						suburbanMaleCount++;
					}
					if(bankRecords[i].getRegion().equals("TOWN")) {
						townMaleCount++;
					}
				}
			}
			System.out.println("\n\nmales having a child and owning a car in Inner city region  :" +innerCityMaleCount );
			System.out.println("males having a child and owning a car in Rural region :" +ruralMaleCount );
			System.out.println("males having a child and owning a car in Suburban city region :" +suburbanMaleCount );
			System.out.println("males having a child and owning a car in Town city region  :" +townMaleCount );
			try{
				fw.write("\r\n\r\nCount of Inner city region males having a child and owning a car :" +innerCityMaleCount+"\r\nCount of Rural region males having a child and owning a car : "+ruralMaleCount+"\r\nCount of Suburban city region males having a child and owning a car :" +suburbanMaleCount+"\r\nCount of Town city region males having a child and owning a car :" +townMaleCount);
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			}
		
		}
