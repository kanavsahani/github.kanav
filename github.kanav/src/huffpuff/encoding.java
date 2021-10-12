package huffpuff;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class encoding {

    private final Map<Character, Integer> frequencyMap;

    public encoding(){
        this.frequencyMap = new HashMap<>();
        try {
            FileReader reader = new FileReader("EnglishToArabicDictionary.txt");
            int charNumber = -1;
            while((charNumber = reader.read()) != -1) {
                char readCharacter = (char) charNumber;
                int frequency = this.frequencyMap.getOrDefault(readCharacter, 0);
                frequency++;
                this.frequencyMap.put(readCharacter, frequency);
            }
           PriorityQueue<Branch<Character>> queue = new PriorityQueue();
           for (Character c: frequencyMap.keySet())
        	   queue.add(new Branch(c), frequencyMap.get(c));
           
           
   		while (queue.size() > 1) {
   			Branch branch1 = queue.pop(), branch2 = queue.pop();
			Branch branchtemp = new Branch(branch1, branch2);
			queue.add(branchtemp, );
		}
		System.out.println(tree(0));
           
           
        } 
        catch(IOException ex) {
            ex.printStackTrace();
        }

        
        this.frequencyMap.forEach((key, value) -> System.out.println("Key: " + key + " | Value: " + value));
    }
    public static void main(String[] args) {
        new encoding();
        
    }
}