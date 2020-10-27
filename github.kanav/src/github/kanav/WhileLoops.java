package github.kanav;
import java.util.Scanner;

public class WhileLoops {
	
	Scanner input = new Scanner(System.in);

		//definite finite
			public void numsBetween() {
				System.out.println("Enter a number");
				int num1 = input.nextInt();
				System.out.println("enter a 2nd number");
				int num2 = input.nextInt();
				
				int count = num1;
				while(count <= num2) {
					System.out.println(count);
					
					count ++;
				}
			}
			//definite finite
			public void doubledouble() {
				System.out.println("Enter a base");
				double num3 = input.nextDouble();
				System.out.println("Enter a coefficient");
				double num4 = input.nextDouble();
				
				int x = 0;
				while(x <= 5) {
					
					System.out.println(num4 * Math.pow(num3, x));
					x++;
				}
				
			}
			//definite finite
			public void squareroot() {
				System.out.println("Enter a number");
				int findInteger = input.nextInt();
				
				int x = 0;
				while (x <= findInteger) {
					if(x*x == findInteger) {
						System.out.println("the sqrt of " + findInteger + " is " + x);
						break;
					}
						x++;
					}
				if (x*x != findInteger) {
					System.out.println("there is no sqrt");
					
				}
				}
			
		
		public static void main(String[] args) {
			WhileLoops runner = new WhileLoops();
			runner.numsBetween();
			runner.doubledouble();
			runner.squareroot();
		}
}
