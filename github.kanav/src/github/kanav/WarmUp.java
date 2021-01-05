package github.kanav;

import java.util.Arrays;

public class WarmUp {
	
	public void words(String[] sentence) {
		for (int i = 0; i < sentence.length; i++) {
			System.out.println(sentence[i]);
		}
	}
	public void list(int n) {
		int [] sequence = new int [n];
		for (int i = 1; i < n; i++) {
			System.out.println(sequence[i] += i);
		}
		System.out.println(n);
	}
	public void average(int[] nums) {
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			
				sum += nums[i];
		}
		System.out.println(sum/nums.length);
	}
	public void double1(int[] nums) {
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i]*2;
			System.out.println(nums[i]);
		}
		
	}
	public void trim(int[] nums) {
		int min = nums[0], max = nums[0];
		for (int i = 0; i < nums.length; i++) {
				if (min > nums[i]) {
					min = nums[i];
			}
				else if (max < nums [i]) {
					max = nums[i];
				}	
		}
		int[] trimmedArray = new int[nums.length-2];
		
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != min && nums[i] != max) {
				trimmedArray[j] = nums[i];
				j++;
			}
		}
		System.out.println(Arrays.toString(trimmedArray));
	}
	public void fib(int n) {
		int [] sequence = new int [n];
		sequence[0] = 1;
		sequence[1] = 1;
		
		for (int i = 2; i < sequence.length; i++) {
			sequence[i] = sequence[i-1] + sequence[i-2];
		}
		System.out.println(Arrays.toString(sequence));
		
	}
	public void divide(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] % nums[i-1] == 0) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
	
	public static void main (String[] args) {
		
		WarmUp run = new WarmUp();
		int[] nums = {4,2,6};
		String[] words = {"I", "like", "cheese"};
		run.words(words);
		run.list(5);
		run.average(nums);
		run.double1(nums);
		run.fib(15);
		run.divide(nums);
	}
}
