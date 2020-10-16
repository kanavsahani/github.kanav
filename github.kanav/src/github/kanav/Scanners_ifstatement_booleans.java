package github.kanav;

import java.util.Scanner;

public class Scanners_ifstatement_booleans {

	private Scanner input = new Scanner(System.in);
	
	
	//the scanner
	//type in a double

	public void KeyPress() {
		System.out.println("type a number");
		double i = input.nextDouble();
		System.out.println("Press s, e, d, o, or w");
	
		String answer = input.next();
	
		if (answer.equals("s"))
			System.out.println(Math.sqrt(i));
		else if (answer.equals("e")) {
			if (i%2 == 0) {
				System.out.println("even");
			}
			else if(i%2 == 1) {
				System.out.println("odd");
			}
			else {
				System.out.println("not a whole number");
			}
		}
		else if (answer.equals("d")) {
			System.out.println("type a 2nd number");
			double i2 = input.nextDouble();
			if(i%i2 == 0) {
				System.out.println("it is a factor");
				
			}
			else {
				System.out.println("it is not a factor");
			}
		}
			
		else if (answer.equals("w")) {
			System.out.println("type a 2nd number");
			double i2 = input.nextDouble();
			if(i > i2-3 && i < i2+3) {
				System.out.println("it is within 3");
			}
			else {
				System.out.println("It is not within 3");
			}
		}
		else if (answer.equals("o")) {
			System.out.println("type a 2nd number");
			i = input.nextDouble();
			KeyPress();
		}
			
			
		else {
			 input_error();
			 KeyPress();
		}
		
		}
	
		public void input_error() {
			System.out.println("Not a valid input");
		}
		public static void main(String[] args) {
			new Scanners_ifstatement_booleans(); 
			Scanners_ifstatement_booleans tester = new Scanners_ifstatement_booleans();
			tester.KeyPress();
		}
	}
