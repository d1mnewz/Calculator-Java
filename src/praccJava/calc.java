package praccJava;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class calc {

	public calc() {
		//System.out.println("hello calc");
		System.out.println("Calculator via Java v0.0.1");
	}
	private double digit1;
	private double digit2;
	private double res;
	private Scanner _in;
	

	public void Calculate(String str) throws IllegalArgumentException
	{
		if(str.equals("0") || str.isEmpty() || Integer.parseInt(str) > 4)
		{
			System.exit(0);
		}
		try {
			this.GetDigits();
		} catch (IOException e) {
			
			System.out.println("Invalid input");
		}
			switch(str)
			{

			case "1":
				//System.out.println("1 pressed");
				
				this.res = this.digit1 + this.digit2;
				System.out.println("result of " + digit1 + " + " + digit2 + " = " + this.res);
				//JOptionPane.showMessageDialog(null, (int)this.res, "InfoBox: " + "Result", JOptionPane.INFORMATION_MESSAGE);
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
					throw new IllegalArgumentException("Argument 'digit2' is 0");
				}
				this.res = this.digit1 / this.digit2;
				System.out.println("result of " + digit1 + " / " + digit2 + " = " + this.res);
				
				break;
				
			default:
				System.out.println("go away idiot =)");
				break;
			
			}
	}
	
	public void Menu()
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner scan = new Scanner(new InputStreamReader(System.in));
		System.out.println("\tMenu\t");
		System.out.println("1. plus.");
		System.out.println("2. minus");
		System.out.println("3. multiply.");
		System.out.println("4. divide");
		System.out.println("0. exit");
		String choice = null;
		try {
			choice = br.readLine();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "InfoBox: " + "Exception!", JOptionPane.INFORMATION_MESSAGE);
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
		try {
			System.in.read();
		} catch (IOException e) {
			e.getMessage();
		}
		System.exit(0);
		
		
	}
	
	public void GetDigits() throws IOException
	{
		System.out.println("Digit 1 :");
		_in = new Scanner(System.in);
		try
		{
			this.digit1 = Double.parseDouble(_in.next());
		}
		catch (InputMismatchException ex)
		{	
			System.out.println("wtf u entered m8");
			
		}
		//System.out.println(digit1);
		System.out.println("Digit 2 :");
		try
		{
			this.digit2 = Double.parseDouble(_in.next());
		}
		catch (InputMismatchException ex)
		{	
			System.out.println("wtf u entered m8");
			
		}
		//System.out.println(digit2);
	}
	
	
	
	

	public static void main(String[] args) {
		calc obj = new calc();
		//obj.main(null);
		obj.Menu();
		
	}

}
