package github.kanav;

public class WarmUpStrings {
	
	public void pigLatin (String word) {
		word = word + word.charAt(0) + "ay";
		System.out.println(word.substring(1));
	}
	public void letters(String word, char letter) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == letter) {
				System.out.println("$");
			}
			else {
				System.out.println(word.charAt(i));
			}
		}
	}
	public void longest (String[] arr) {
		String max = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > max.length()) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}
	
	
	public static void main (String[] args) {
		WarmUpStrings runner = new WarmUpStrings();
		String n = "banana";
		runner.pigLatin(n);
		runner.letters(n, 'n');
		runner.longest(new String [] {"hi", "hello", "bye"});
	}
}
