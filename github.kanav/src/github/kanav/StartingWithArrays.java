package github.kanav;

import java.util.Scanner;

public class StartingWithArrays {
	private int[] y = new int[7];
	
	public void display() {
		for (int i = 0; i < 7; i++) {
		
			System.out.print(y[i] + " ");
		}
		System.out.println();
	}
	public void onetoN(int n) {
		for (int i = 0; i < n; i++) {
			y[i] = i+1;
			
		}
		display();
	}
	public void swap() {
		int temp = y[0];
		y[0] = y[y.length-1];
		y[y.length-1] = temp;
		display();
	}
	public void userArray() {
		for (int i = 0; i < 7; i++) {
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			y[i] = num;
		}
		display();
		
	}
	public void reverse() {
		for (int i = 0, j = y.length-1; i < y.length/2; i++, j--) {
			int temp = y[i];
			y[i]=y[j];
			y[j] = temp;
		}
		display();
	}
	
	public static void main(String[] args) {
		StartingWithArrays runner = new StartingWithArrays();
		runner.display();
		runner.onetoN(5);
		runner.swap();
		runner.userArray();
		runner.reverse();
	}
}
