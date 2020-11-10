package github.kanav;
import java.util.Scanner;

public class ForLoops_NestedLoops {
	
	Scanner input = new Scanner(System.in);
	
	public void alphabet() {	
		char c;
	        for(c = 'A'; c <= 'Z'; c++) {
	            System.out.print(c + " ");
	    }
	}
	public void primeNumbers() {
		int x = 100;
	        
		for(int j = 1; j  <= x; j++) {
			boolean isPrime = true;
		for (int i = 2; i < j; i++) {
			
			if (j % i == 0) {
				System.out.println(j +" is " + "not prime");
				isPrime = false;
				break;
			}
		}
			if (isPrime) {
				System.out.println(j + " is " + "prime");
			}
		}
	}
		public void sumOfNumbers() {
			  int num = 5, count = 1, total = 0;

			  for(int i = count; i <= num; i++) {
		           total = total + count;
		           count++;
			  }

		       System.out.println("sum is "+total);
		    }
		public void riddle() {
			System.out.println("What is black, white, and read all over?");
			String x = input.next();
			while(x != "newspaper" ) {
				System.out.println("What is black, white, and read all over?");
				String x1 = input.next();
			
				if(x1 .equals ("newspaper")) {
					System.out.println("Correct!");
					break;
				}
				
			}
			
		}
		public void printPascalTriangle() {
			int rows = 5;
	        for (int i = 0; i < rows; i++) {
	            int number = 1;
	            for (int j = 0; j <= i; j++) {
	                System.out.print(number + " ");
	                number = number * (i - j) / (j + 1);
	            }
	         
	            System.out.println();
	        }
	        }


	
	
	
	
	
public static void main(String[] args) {
	ForLoops_NestedLoops runner = new ForLoops_NestedLoops();
	runner.alphabet();
	runner.primeNumbers();
	runner.sumOfNumbers();
	runner.riddle();
	runner.printPascalTriangle();
}
}

	

