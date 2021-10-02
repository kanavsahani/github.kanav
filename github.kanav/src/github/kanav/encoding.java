package github.kanav;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class encoding {

    private final Map<Character, Integer> frequencyMap;

    {
        this.frequencyMap = new HashMap<>();
        try{
            FileReader reader = new FileReader("EnglishToArabicDictionary.txt");
            int charNumber = -1;
            while((charNumber = reader.read()) != -1) {
                char readCharacter = (char) charNumber;
                int frequency = this.frequencyMap.getOrDefault(readCharacter, 0);
                frequency++;
                this.frequencyMap.put(readCharacter, frequency);
            }
        }catch(IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Frequency Map:");
        this.frequencyMap.forEach((key, value) -> System.out.println("Key: " + key + " | Value: " + value));
    }
    public static void main(String[] args) {
        new encoding();
    }
}