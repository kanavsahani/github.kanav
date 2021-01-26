package github.kanav;

public class ModifyingStrings {
	public void ESTVerbs (String adverb) {
		adverb = adverb.substring(0,adverb.length() - 2) + "est";
		System.out.println(adverb);
	}
	public void PREVerbs(String averb) {
		averb = "un" + averb.substring(3);
		System.out.println(averb);
	}
	public void suffixCheck(String x, String z) {
		
		if (x.substring(x.length()-z.length()) .equals (z)) {
			String word = x.substring(x.length()-z.length());
			word = x.substring(0,x.length()-z.length()) + "ine";
			System.out.println(word);
		}
		else {
			System.out.println(x + "est");
		}
	}
	public void changeEtoQ (String word) {
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'e') {
				word = word.substring(0,i) + "q" + word.substring(i+1);
			}
		}
		System.out.println(word);
	}
	public void StringeyArray (String sentence) {
		String[] str_Array = sentence.split(" ", sentence.length()); 
        for ( int i = 0; i < str_Array.length ; i++ ) 
             System.out.println(str_Array[i]); 
	}
	
	
	public static void main (String[] args) {
		ModifyingStrings runner = new ModifyingStrings();
		String x = "quickly";
		String z = "ly";
		String y = "predisposed";
		String word = "hello everyone";
		runner.ESTVerbs(x);
		runner.PREVerbs(y);
		runner.suffixCheck(x,z);
		runner.changeEtoQ(word);
		runner.StringeyArray(word);
	}
}
