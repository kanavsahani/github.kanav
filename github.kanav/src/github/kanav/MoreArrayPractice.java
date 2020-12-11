package github.kanav;
import java.util.Scanner;

public class MoreArrayPractice {
	
	
	
	public void display(int j[]) {
		for (int i = 0; i < j.length; i++) {
		
			System.out.print(j[i] + " ");
		}
		System.out.println();
	}
	public void display(String j[]) {
		for (int i = 0; i < j.length; i++) {
		
			System.out.print(j[i] + " ");
		}
		System.out.println();
	}
	public void average(double y[]) {
		double total = 0;
		for(int i=0; i<y.length; i++){
        	total = total + y[i];
        }
		double average = total / y.length;
		System.out.print("The average is: " + average);
	}
	public void PosOrNeg(int y[]) {
		String j[] = new String[y.length];
		
		for (int i=0; i <y.length; i++) {
			if (y[i] >= 0){
				j[i] = "Pos";
			}
			if (y[i] < 0) {
				j[i] = "Neg";
			}
		}
		System.out.println();
		display(j);
	}
	public void merge(int n[], int z[]) {
		int j[] = new int[n.length+z.length];
		for (int i=0; i <n.length; i++) {
			j[i] = n[i];
		}
		for (int i=n.length; i <j.length; i++) {
			j[i] = z[i-n.length];
		}
		display(j);
	}
	public void ArrayDetector(char[] n, char letter) {
		boolean found = false;
		for (int i = 0; i < n.length; i++) {
			if(n[i] == letter) {
				System.out.println("Contains "+letter);
				found = true;
				break;
			}
		if (!found) {
			System.out.println("Does not contain "+letter);
		}
		}
	}
	public void IndexDetector(String n[], String word) {
		boolean found = false;
		for (int i = 0; i < n.length; i++) {
			if (word.equals(n[i])) {
				System.out.println(i);
				found = true;
				break;
			}
		}
		if (!found)
			System.out.println(-1);
	}
	public void CommonNumbers(int [] n, int [] z) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < z.length; j++) {
				if (n[i] == z[j]) {
					System.out.println(n[i]);
				}
			}
		}
	}
	public static void main(String[] args) {
		MoreArrayPractice runner = new MoreArrayPractice();
		runner.average(new double [] {19.5, 12.69, 16.3, 204, 13.3});
		runner.PosOrNeg(new int [] {5, -4, 2, -8});
		runner.merge(new int [] {5,6,7,8}, new int [] {1,2,3,4});
		runner.ArrayDetector(new char [] {'i','g','o','d'}, 'g');
		runner.IndexDetector(new String []{"Man","CS","Rocks"}, "Rocks");
		runner.CommonNumbers(new int [] {4,1,7,3,4}, new int[] {8,2,3,4});
	}
}
