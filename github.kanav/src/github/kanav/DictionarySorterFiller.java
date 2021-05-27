package Dictionary;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionarySorterFiller {
	
	public static String mode = "selection";	
	
	public static void main(String[] args) throws IOException {
		// generates the word list from the dictionary file
		BufferedReader in = new BufferedReader(new FileReader("wordsShuffledSmaller.txt"));
		List<String> words = new ArrayList<String>();
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			words.add(line.trim());
		}
		in.close();
		long startTime = System.currentTimeMillis();
		if (mode.equals("selection"))
			selectionSort(words);
		else if (mode.equals("insertion"))
			selectionSort(words);
		else
			selectionSort(words);
		System.out.println("runtime: " + (System.currentTimeMillis() - startTime));
		
		BufferedWriter out = new BufferedWriter(new FileWriter("wordsSorted.txt"));
		for (String s : words)
			out.write(s + "\n");
		out.close();
	}
	
	public static void selectionSort(List<String> words) {
		for ( int j = 0; j < words.size()-1; j++) {
			int minI = j;
			
			for (int i = j; i < words.size(); i++) {
				if (words.get(minI).compareTo(words.get(i)) > 0) {
					minI = i;
					
				}
			}

		String temp = words.get(j);
		words.set(j, words.get(minI));
		words.set(minI, temp);
		}
	}

	public static void mergeSort(List<String> words) {
		mergeSort(words, 0, words.size()-1);
	}
	
	public static void mergeSort(List<String> words, int start, int end) {
		if (start < end) {
			int middle = (start+end)/2;
			mergeSort(words,start,middle);
			mergeSort(words,middle+1,end);
			merge(words,start,middle,end);
		}
	}
	
	public static void merge(List<String> words, int start, int mid, int end) {
		List<String> temp = new ArrayList<String>();
		int i = start, j = mid+1;
		while (i <= mid && j <= end) {
			if (words.get(i).compareTo(words.get(j)) < 0) { 
				temp.add(words.get(i));
				i++;
			}
			else {
				temp.add(words.get(j));
				j++;
			}
		}
		while (i <= mid) {
			temp.add(words.get(i));
			i++;
		}
		while(j <= end) {
			temp.add(words.get(j));
			j++;
		}
		int k = start;
		for (String s : temp) {
			words.set(k, s);
			k++;
		}
	}
}
