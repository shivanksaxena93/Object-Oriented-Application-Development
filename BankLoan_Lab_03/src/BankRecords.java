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
