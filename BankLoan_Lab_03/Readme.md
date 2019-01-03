# PROJECT CODE

## Objective: Program to perform data analysis of class objects of lab 2.

## 1)	Client.java


/**
 * 
 * @author Shivank
 *@version 1.3
 *@since 2017/10/01
 */

public abstract class Client
{
	public  abstract void readData();
	public  abstract void processData();
	public abstract void printData();
	

}

## 2)	Records.java

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

## 3)	BankRecords.java
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
/**
 * 
 *@author Shivank
 *@version 1.5
 *@since 2017/10/01
 */
public class BankRecords extends Client
{
	private String region;
	private String marriage;
	private String car;
	private String current_act;
	private String save_act;
	private String mortgage;
	private String pep;
	private int age , children;
	private double income;
	
	 static BankRecords[] bankRecords;
	
	static ArrayList<List<String>> array = new ArrayList<List<String>>();

	private String id,sex;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getCar() {
		return car;
	}
	public void setCar(String car) {
		this.car = car;
	}
	public String getCurrent_act() {
		return current_act;
	}
	public void setCurrent_act(String current_act) {
		this.current_act = current_act;
	}
	public String getSave_act() {
		return save_act;
	}
	public void setSave_act(String save_act) {
		this.save_act = save_act;
	}
	public String getMortgage() {
		return mortgage;
	}
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}
	public String getPep() {
		return pep;
	}
	public void setPep(String pep) {
		this.pep = pep;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	@Override
	public void readData() {
			BufferedReader br = null;
	     //initializing object of reader and setting file path to root of project
	     	try {
				br = new BufferedReader(new FileReader(new File("bank-Detail.csv")));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

				String line;
	            
	        //each record to be readed in CVS file
				try {
					while ((line = br.readLine()) != null) {
					 //Analyzing each record in parts in csv file by a comma ( , )
					 //into a list stored in the arraylist-> Arrays
						array.add(Arrays.asList(line.split(",")));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

		
		
	}

	@Override
	public void processData() 
	{
		 bankRecords = new BankRecords[601];
		 int i=0;
		   
		    //create for each loop to cycle thru arraylist of values 
		    //and PASS that data into your record objects' setters 
		    for (List<String> rowData: array){
		      //initialize array of objects
		    	
		    	bankRecords[i] = new BankRecords();
		    	//call setters below and populate them, item by item
		    	bankRecords[i].setId(rowData.get(0)); //get 1st column
		    	bankRecords[i].setAge(Integer.parseInt(rowData.get(1)));
		    	bankRecords[i].setSex(rowData.get(2));
		    	bankRecords[i].setRegion(rowData.get(3));
		    	bankRecords[i].setIncome(Double.parseDouble(rowData.get(4)));
		    	bankRecords[i].setMarriage(rowData.get(5));
		    	bankRecords[i].setChildren(Integer.parseInt(rowData.get(6)));
		    	bankRecords[i].setCar(rowData.get(7));
		    	bankRecords[i].setSave_act(rowData.get(8));
		    	bankRecords[i].setCurrent_act(rowData.get(9));
		    	bankRecords[i].setMortgage(rowData.get(10));
		    	bankRecords[i].setPep(rowData.get(11));
		    	if(i<600) {
		    		i++;
		    	}
		    	else {
		    		break;
		    	}
		    }

	}

	@Override
	public void printData() 
	{
		System.out.println("==================================================================================================================\n|ID\t\t|AGE\t\t|SEX\t\t\t|Region\t\t\t|INCOME(in $)\t\t|Mortgage\n==================================================================================================================");
    	int i;
    	for (i=0; i<25; i++ )
    	{
    		System.out.printf("\n|%s\t|%d\t\t|%s\t\t\t|%-12s\t\t|%9.2f\t\t|%s",bankRecords[i].getId(),bankRecords[i].getAge(),bankRecords[i].getSex(),bankRecords[i].getRegion(),bankRecords[i].getIncome(),bankRecords[i].getMortgage());
		
	}
    	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	System.out.println("\n\nCurr dt=" + timeStamp + "\nProgrammed by Shivank Saxena ");
	}
	
}






## 4)	FemaleComparator.java



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

## RESULTS:
![Result](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/BankLoan_Lab_03/Output.JPG)
 
