package github.kanav;

public class IfStatements {
	
		
		public void testing(int x) {
			if (x > 0) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
			
		public void evenOdd (int x) {  
			if (x % 2 == 0) {
				System.out.println("even");
			}
			else {
				System.out.println("odd");
			}
		}
		public void characterTest (char c) {
			if(c > 91) {
				System.out.println("uppercase");
				
			}
			else {
				System.out.println("lowercase");
				}
			}
		public void multipleof10(int x) {
			if(x % 10 == 0) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
		public void biggestparm (double x, double y, double z) {
			
			if(z<x && z<y) {
				System.out.println(Math.max(x, y));
			}
				else if(z<x && z>y) {
					System.out.println(Math.max(x, z));
				}
				else if(z>x && z<y) {
					System.out.println(Math.max(y
							, z));
				}
			}
				
		
		
			
		
	public static void main(String[] args) {
		
		IfStatements tester = new IfStatements();
		tester.testing(-13);
		tester.evenOdd(8);
		tester.characterTest('Q');
		tester.multipleof10(100);
		tester.biggestparm(5, 10, 8);
	}
	
}
