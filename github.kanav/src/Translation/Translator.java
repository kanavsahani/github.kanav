package Translation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Translator {
	    private Map<String, String> wordMap;
	    private Scanner sc;
	    private void doTheTranslate() throws IOException {
	        this.wordMap = new HashMap<>();
	        this.sc = new Scanner(System.in);
	        wordReader();
	        while (true) {
	            System.out.println("What do you want to translate from English to Arabic?");
	            String translate = sc.nextLine();
	            System.out.println(wordMap.getOrDefault(translate.toLowerCase(), "Not Found"));
	        }
	    }
	    private void wordReader() throws IOException {
	        FileReader input = new FileReader("EnglishToArabicDictionary.txt");
	        BufferedReader read = new BufferedReader(input);
	        read.readLine();
	        String english, arabic;
	        while((english = read.readLine()) != null) {
	            arabic = read.readLine();
	            wordMap.put(english, arabic);
	        }
	    }
	public static void main(String[] args) throws IOException {
		new Translator().doTheTranslate();
		
	}
}
