package praccJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;



public class calc {

	public calc() {
		
		System.out.println("Calculator via Java v0.0.1");
	}
	private double digit1;
	private double digit2;
	private double res;
	private Scanner _in; 
	

	public void Calculate(String str) throws IllegalArgumentException // in case of divide by zero
	{
		if(str.equals("0") || str.isEmpty() || Integer.parseInt(str) > 4)
		{
			System.exit(0); // in case if input for menu is invalid
		}
		
		try 
		{
			this.GetDigits(); // if input for menu is valid -> get two digits for operation
		} 
		catch (IOException e) 
		{
			
			System.out.println("Invalid input"); // if digits are invalid or smth
		}
			switch(str)
			{

			case "1":
				this.res = this.digit1 + this.digit2;
				System.out.println("result of " + digit1 + " + " + digit2 + " = " + this.res);
				break;
				
			case "2":
				
				this.res = this.digit1 - this.digit2;
				System.out.println("result of " + digit1 + " - " + digit2 + " = " + this.res);
				break;
				
			case "3":
				this.res = this.digit1 * this.digit2;
				System.out.println("result of " + digit1 + " * " + digit2 + " = " + this.res);
				break;
			
			case "4":
				if(this.digit2 == 0)
				{
					throw new IllegalArgumentException("Argument 'digit2' is 0"); // in case of divide by zero we -> 
																			      //throw exception that is being handled in Menu()
				}
				this.res = this.digit1 / this.digit2;
				System.out.println("result of " + digit1 + " / " + digit2 + " = " + this.res);
				break;
				
			default:
				System.out.println("invalid input."); 
				break;
			
			}
	}
	
	public void Menu()
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // use this to read choice from keyboard
		System.out.println("\tMenu\t");
		System.out.println("1. plus.");
		System.out.println("2. minus");
		System.out.println("3. multiply.");
		System.out.println("4. divide");
		System.out.println("0. exit");
		String choice = null; // null`ing String so we can access it
		try 
		{
			choice = br.readLine(); 
		} 
		catch (IOException e1) 
		{
			System.out.println(e1.getMessage());  // if our choice isnt parseable
		}
		try
		{
			this.Calculate(choice);
		}
		catch (IllegalArgumentException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		System.out.println("press any key to exit...");
		try 
		{
			System.in.read();
		} catch (IOException e)
		{
			e.getMessage();
		}
		System.exit(0);
		
		
	}
	
	public void GetDigits() throws IOException
	{
		
		_in = new Scanner(System.in);
		System.out.println("Digit 1 :");
		try
		{
			this.digit1 = Double.parseDouble(_in.next());
		}
		catch (InputMismatchException ex)
		{	
			System.out.println("invalid input");
			
		}
		
		System.out.println("Digit 2 :");
		try
		{
			this.digit2 = Double.parseDouble(_in.next());
		}
		catch (InputMismatchException ex)
		{	
			System.out.println("invalid input");
			
		}
		
	}
	
	
	
	

	public static void main(String[] args) {
		calc obj = new calc(); // creating an object of class
		obj.Menu(); // accessing menu that calling getDigits() Calculate()
		
	}

}
