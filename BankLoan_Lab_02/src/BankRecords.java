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
	
	private BankRecords a[] = new BankRecords[600];
	
	private ArrayList<List<String>> array = new ArrayList<>();

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
				br = new BufferedReader(new FileReader
				         (new File("bank-Detail.csv")));
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
				//for(int i=0;i<array.size();i++)
				//{
					//System.out.println(array.get(i));
				//}

		
		
	}

	@Override
	public void processData() 
	{
		 int i=0;

		    //create for each loop to cycle thru arraylist of values 
		    //and PASS that data into your record objects' setters 
		    for (List<String> rowData: array){
		      //initialize array of objects
		    	a[i] = new BankRecords();
		    	//call setters below and populate them, item by item
		    	a[i].setId(rowData.get(0)); //get 1st column
		    	a[i].setAge(Integer.parseInt(rowData.get(1)));
		    	a[i].setSex(rowData.get(2));
		    	a[i].setRegion(rowData.get(3));
		    	a[i].setIncome(Double.parseDouble(rowData.get(4)));
		    	a[i].setMarriage(rowData.get(5));
		    	a[i].setChildren(Integer.parseInt(rowData.get(6)));
		    	a[i].setCar(rowData.get(7));
		    	a[i].setSave_act(rowData.get(8));
		    	a[i].setCurrent_act(rowData.get(9));
		    	a[i].setMortgage(rowData.get(10));
		    	a[i].setPep(rowData.get(11));
		    	
		    	i++;
		    }

       /*continue processing array list values into each array object->
        a[] by index*/
      

		
		
	}

	@Override
	public void printData() 
	{
		System.out.println("==================================================================================================================\n|ID\t\t|AGE\t\t|SEX\t\t\t|Region\t\t\t|INCOME(in $)\t\t|Mortgage\n==================================================================================================================");
    	int i;
    	for (i=0; i<25; i++ )
    	{
    		System.out.printf("\n|%s\t|%d\t\t|%s\t\t\t|%-12s\t\t|%9.2f\t\t|%s",a[i].getId(),a[i].getAge(),a[i].getSex(),a[i].getRegion(),a[i].getIncome(),a[i].getMortgage());
		
	}
    	String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
	System.out.println("\n\nCurr dt=" + timeStamp + "\nProgrammed by Shivank Saxena ");
	}
	
}
