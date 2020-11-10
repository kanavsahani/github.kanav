package github.kanav;


public class MoreWithNestedLoops {
	
	
	
	public void looping(int n) {
		
		for(int i = 1; i <= n; i++) {
			for (int j = i; j < n+i; j++) {
			
				System.out.print(j <=5 ? j : j-5);
			
			}
			System.out.println();
		}
		
	}
	
	public void drawTri(int y) {
		for (int i = 0; i < y; i++) {
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print('X');
                number = number * (i - j) / (j + 1);
            }
         
            System.out.println();
        }
		
	}
	public void drawdiamond(int y) {
		for (int i = 0; i < y; i++) {
            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
                number = number * (i - j) / (j + 1);
            }
         
            System.out.println();
            
        }
		for (int i = y; i >= 0; i--) {
			int number = 1;
			for (int j = 0; j <= i; j++) {
                System.out.print('*');
                number = number * (i - j) / (j + 1);
            }
			System.out.println();
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		MoreWithNestedLoops run = new MoreWithNestedLoops();
		run.looping(5);
		run.drawTri(5);
		run.drawdiamond(5);
	}
}
