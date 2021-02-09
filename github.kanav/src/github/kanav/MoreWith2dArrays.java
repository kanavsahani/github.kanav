package github.kanav;

import java.sql.Array;

public class MoreWith2dArrays {
	public void display (int [] [] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				
				System.out.print(n[i] [j] + " ");
			}
			System.out.println();
		}
	}
	public void sqaureArrray (int n) {
		int [] [] n1 = new int [n] [n];
		int count = 1;
		for (int i = 0; i < n1.length; i++) {
			for (int j = 0; j < n1[i].length; j++) {
			
					n1[i] [j] = count;
					count++;
			}
		}
		display(n1);
	}
	public void maximum(double [] [] n3) {
		
		double max = n3 [0] [0];
		
		for (int i = 0; i < n3.length; i++) {
			for (int j = 0; j < n3[i].length; j++) {
				
				if (n3 [i] [j] > max) {
					max = n3 [i] [j];
				}
			}
		}
		System.out.println(max);
	}
	public void add(double [] [] n) {
		int count = 0;
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				count += n[i] [j];
			}
		}
		System.out.println(count);
	}
	public void combine(double [] [] n) {
		int count = 0;
		int[] arr = new int[n.length];
			for (int i = 0; i < n.length; i++) {
				count = 0;
				for (int j = 0; j <n[i].length; j++) {
					count += n[i] [j];
			}
				arr[i] = count;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public static void main(String[] args) {
		MoreWith2dArrays run = new MoreWith2dArrays();
		int[] [] n = new int[5] [5];
		int n1 = 5;
		double[] [] n3 = { {6,3,2} , {5,2,8}, {1} };		
	
		run.display(n);
		run.sqaureArrray(n1);
		run.maximum(n3);
		run.add(n3);
		run.combine(n3);
	}
}
