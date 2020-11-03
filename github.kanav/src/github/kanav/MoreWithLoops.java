package github.kanav;
import java.util.Scanner;

public class MoreWithLoops {

	Scanner input = new Scanner(System.in);
	
	public void MagicalNumber(){
		
		System.out.println("Enter a number");
		int x = input.nextInt();
		while(x != 6) {
			System.out.println("Enter a number");
			x = input.nextInt();
		}
		
			System.out.println("you found the number!");
		
	}
	
	
	public void NegativeToPositive() {
		
		System.out.println("Enter a number");
		int x = input.nextInt();
		int y = x*-1;
		while(x >= y) {
			
			System.out.println(y);
			y++;
			
		}
	}
	
	
	public void HiPrinter() {
		System.out.println("Enter a number");
		int num = input.nextInt();
		while (num > 0) {
			num--;
			System.out.println("hi");
		}
	}
	
	
	public void GamePlay () {
		System.out.println("Do you want to keep playing?");
		String Game = input.next();
		while(Game .equals ("yes")) {
			System.out.println("Do you want to keep playing?");
			Game = input.next();
		}
		System.out.println("Game Over");
	}
	
	
	
		public void Factorials() {
			System.out.println("Enter a number");
			int num = input.nextInt();
			int count = num;
			int product = 1;
			
			while (count >=1) {
				product = product * count;
				
				count--;
			}
			System.out.println(product);
		}
		public void LCM() {
			System.out.println("Enter a number");
			int num = input.nextInt();
			System.out.println("Enter a 2nd number");
			int num2 = input.nextInt();
			
			int count = Math.max(num, num2);
			
			while (count % num != 0 && count % num2 != 0) {
				count++;
				}
			System.out.println(count);
			}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		MoreWithLoops runner = new MoreWithLoops();
		runner.MagicalNumber();
		runner.NegativeToPositive();
		runner.HiPrinter();
		runner.GamePlay();
		runner.Factorials();
		runner.LCM();
	}
	
}
