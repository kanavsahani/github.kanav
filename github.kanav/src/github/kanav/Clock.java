package github.kanav;

public class Clock {

	
	
	public void setTime(int x) {
		
		System.out.println(x);
	}
	public void tick() {
		
		
	}
	public void displayTime() {
		for (int add1 = 57; add1 <= 59; add1++)
		System.out.println(add1);
		
		
	}

	
	public static void main(String[] args) {
		Clock tester = new Clock();
		
		// should display the time to be 56, 57, 58, 59, 0, 1, etc.
		tester.setTime(56);
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
	}
}