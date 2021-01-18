package github.kanav;

import java.util.Random;

public class IntroToStrings {
	
	public void printhalf(String n) {
		System.out.println(n.substring(n.length()/2));
	}
	public void contains (String Bigword, String littleword) {
		
		if (Bigword.indexOf(littleword) != 1) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	public void backwards (String n) {
		
		char[] try1 = n.toCharArray();
		char[] try2 = new char[try1.length];
		int i = n.length()-1;
		for (int j = 0; j < try2.length; j++, i--) {
				try2[j] = try1[i];
			}
		System.out.println(try2);
		}
		
	public void concentration() {
		String value = "Jamaica";
		String value1 = "Caribbean";
		value = value.substring(1);
		value1 = value1.substring(1);
		System.out.println(value + value1);
		}
		
	public static void main (String[] args) {
		IntroToStrings runner = new IntroToStrings();
		String n = "hi there";
		runner.printhalf(n);
		runner.contains(n, n);
		runner.backwards(n);
		runner.concentration();
	}
}
