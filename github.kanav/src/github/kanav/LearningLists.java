package github.kanav;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class LearningLists {
//	public static void secondCharacter(List<Character> characters) {
//		ArrayList<Character> count = new ArrayList<Character>();
//		for (int i = 1; i < characters.size(); i += 2) {
//			if ((double)i%2 == 0 || (double)i%2 == 1) {
//				count.add(characters.get(i));
//			}
//		}
//		System.out.println(count);
//	}
//	public static void doubleDoubles(List<Double> doubleList) {
//		ArrayList<Double> count = new ArrayList<Double>();
//		for (int i = 0; i < doubleList.size(); i++) {
//			count.add(doubleList.get(i)*(2));
//			
//		}
//		System.out.println(count);
//	}
//	public static void printAlpha(int n) {
//		ArrayList<Character> count = new ArrayList<Character>();
//		int count1 = 97;
//		for (int i = 0; i < n; i++){
//			count.add(0, (char)(count1++));
//			count.add((char)(count1++));
//		}
//		System.out.println(count);
//	}
	public static void perfectsquare(int n) {
		ArrayList<Integer> count = new ArrayList<Integer>();
		count.add(0);
		for (int i = 1; i <= (n*n); i++) {
			if ((double)Math.sqrt(i)%1 == 0) {
				count.add(i);
			}
		}
		System.out.println(count);
	}
	
	public static void main(String args[]) {
//		List<Character> characters = Arrays.asList('l','s','j','h', 'i', 'g');
//		secondCharacter(characters);
//		List<Double> doubles = Arrays.asList(5.5, 6.5, 7.6);
//		doubleDoubles(doubles);
//		printAlpha(13);
//		List<String> reversal = Arrays.asList("lists", "are", "great");
//		Collections.reverse(reversal);
//		System.out.println(reversal);
		perfectsquare(10);
	}
}
