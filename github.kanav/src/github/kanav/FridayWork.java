package github.kanav;
public class FridayWork {
	public void digits(int n) {
		while (n > 0) {
			System.out.println(n%10);
			n /= 10;
		}
	}
	public void rectangle(int x, int y) {
		for (int i = 0; i < y; i++) {
			
			for (int j = 0; j < x; j ++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	
	public void singleFactors(int n) {
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				System.out.println(i);
			}
		}
	}
	public void factors(int n) {
		for(int i = 1; i <=n; i++) {
			singleFactors(i);
			System.out.println();
		}
		
	}
	public static void main(String[] args){
		FridayWork runner = new FridayWork();
		runner.digits(5);
		runner.rectangle(3, 2);
		runner.singleFactors(5);
		runner.factors(8);
		}
}