package github.kanav;

public class MoreWithStrings {

	public void lastTwo(String word) {
		int stringlength = word.length();
		String firstTwo = word.substring(0,2);
		String LastLetters = word.substring(stringlength-2);
		
		if (firstTwo.equals(LastLetters)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}		
	}
	public void numWords (String sentence) {
		int count = 0;
		for (int i = 0; i < sentence.length(); i++) {
			
			if (sentence.charAt(i) == ' ') {
				count++;
			}
			
		}
		System.out.println(count+1);
	}
	public void removeE (String sentence) {
		char[] try1 = sentence.toCharArray();
		for (int i = 0; i < try1.length; i++) {
			if (try1[i] == 'e') {
				continue;
			}
			System.out.print(try1[i]);
		}
	}
	public void stringeyArray (String sentence) {
        String[] str_Array = sentence.split(" ", sentence.length()); 
        for (int i=0;i<str_Array.length;i++) 
             System.out.println(str_Array[i]); 
	}
	public void maxBlock(String str) {
		  int len = str.length();
		  int count = 0;
		  int count2 = 1;
		  if (len == 0)
			  System.out.println("0");
		  for (int i = 0; i < len; i++) {
			  if (i < len-1 && str.charAt(i) == str.charAt(i+1))
				  count2++;
			  else
				  count2 = 1;
			  if (count2 > count)
				  count = count2;
		  }
		  System.out.println(count);
		}
	public static void main (String[] args) {
		MoreWithStrings runner = new MoreWithStrings();
		String n = "banananba";
		runner.lastTwo(n);
		runner.numWords("I love chicken");
		runner.removeE("love");
		runner.stringeyArray("AP CS is for nerds");
		runner.maxBlock("aabbbc");
	}
}
