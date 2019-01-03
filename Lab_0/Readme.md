
### Program to calculate the volume and surface area of a
### right circular cylinder.      
### Programmer: Shivank Saxena, File Name: Cylinder.java 


//package for Scanner class objects
import java.util.Scanner;

public class Cylinder
{
public static void main(String args[])
{
	double surfaceArea = 0;
	double height = 0;
	double radius = 0;
	double volume = 0;
	double pie = 3.1416;
	String strName = "";
 // introduce a Scanner class object
 Scanner sc = new Scanner(System.in);

 // declare and initialize the variables
 
  
 

 // greet the program user	
 System.out.println("Welcome to the Volume Program!");
 // prompt user for their name
 System.out.println("please enter your name");
 // read the user name
 strName = sc.nextLine();
 //display the name back to the user
 System.out.println("hello " + strName);
	     
 // input: assign values to the variables	
 System.out.print("Please enter the radius. ");
 radius = sc.nextDouble(); 
 System.out.print("Please enter the height. ");
 height = sc.nextDouble();

//process: compute the required quantity
 volume = pie * radius * radius * height;
 surfaceArea = (2 * pie * radius * height) + (2 * pie * radius * radius);
 // output: display the output to the user
 System.out.print("The volume of the cylinder is: ");
 System.out.print(volume);
 System.out.println(" cubic length units ");
 System.out.print("The Surface of the cylinder is: " + surfaceArea + "square length units" );
 // dismiss the Scanner class object
 sc.close();
}
}

## Result
![Output](https://github.com/ssaxena12/Object-Oriented-Application-Development/blob/master/Lab_0/Output.PNG)
