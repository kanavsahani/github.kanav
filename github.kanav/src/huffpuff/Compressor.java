package huffpuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
// imported everything needed for the file
// My compressor which also contains my decompressor by Kanav Sahani
public class Compressor {
// setting up two hashmaps, one for frequency and one for recursion 
    private final Map<Character, Integer> frequencyMap;
    private final Map<Character, String> recursionMap;
    
    public Compressor(String filename) throws IOException{
    	//start of the compressor constructor, declaring the hashmaps
        this.frequencyMap = new HashMap<>();
        this.recursionMap = new HashMap<>();
        try {
        	// starting the file reader to read the text file
            FileReader reader = new FileReader(filename);
            // variable keeps track of if the reader is reading a character or a blank space
            int charNumber = -1;
            // reads the file and when it is not equal to -1, it moves on because it has read
            // the whole file by that point
            while((charNumber = reader.read()) != -1) {
            	// creating a variable for the specific characters
                char readCharacter = (char) charNumber;
                // calculating the frequency per character
                int frequency = this.frequencyMap.getOrDefault(readCharacter, 0);
                // add 1 per frequency
                frequency++;
                // returning the character and the frequency of it
                this.frequencyMap.put(readCharacter, frequency);
            }
            // creating a priority queue in order to help with compression later
           PriorityQueue<Branch<Character>> queue = new PriorityQueue();
           for (Character c: frequencyMap.keySet())
        	   // for each loop to go through the frequency map and add them all into the PQ with the branches
        	   queue.add(new Branch(c), frequencyMap.get(c));    
   		   while (queue.size() > 1) {
   			   // while loop that ends once the file is empty
   			   int priority = queue.getPriority();
   			   // finds the priority
   			   Branch branch1 = queue.pop();
   			   // uses the pop method (pop the method and removes it too)
   			   int priority2 = queue.getPriority();
   			   // same as above
   			   Branch branch2 = queue.pop();
   			   // same as above
   			   // temporary branch that groups them together (helps with recursive functions)
   			   Branch branchtemp = new Branch(branch1, branch2);
   			   // adds these two and will keep cycling through until it has emptied the file down to one
   			   // single branch
   			   queue.add(branchtemp, priority+priority2);
   		   }   		 
   		   // this is where branches are moved and removed (hence, the pop)
   		   gencodes("", queue.pop());
   		   // setting up the bufferedbitwriter to get ready to edit this compressed file
   		   BufferedBitWriter output = new BufferedBitWriter("CompressedFile");
   		   // print out the recursion map to make sure it works
   		   System.out.println(recursionMap);
   		   // setting up the file reader now
   		   FileReader reader1 = new FileReader(filename);
   		   // same as farther above
   		   int charNumber1 = -1;
   		   // same as farther above
   		   while((charNumber1 = reader1.read()) != -1) {
   			   // same as farther above
   			   char readCharacter = (char) charNumber1;
   			   // difference here is that it is for the recursive steps with 0's and 1's
   			   // this gives every character a separate identity, helping us later
   			   boolean zeroOrone = false;
   			   // helps us differentiate between 0 and 1 in the upcoming if-statements and for loop
   			   for (int i = 0; i < recursionMap.get(readCharacter).length(); i++) {
   				   // for loop to go through whole file
   				   if (recursionMap.get(readCharacter).charAt(i) == '0' ) {
   					   // recursive methods. giving each character separate identity with 0's and 1's
   					   zeroOrone = false;
   				   }
   				   else {
   					   // 0's and 1's
   					   zeroOrone = true;
   				   }
   				   // writes what it is
   	   			   output.writeBit(zeroOrone);
   			   }
   		   }
   		   // close the file
   		   output.close();
        }
        // catch method for mistakes
        catch(IOException ex) {
            ex.printStackTrace();
        }
        
		 // print the frequency map  
        this.frequencyMap.forEach((key, value) -> System.out.println("Key: " + key + " | Value: " + value));
        // set up the inverse hash which helps for de compresssing
        HashMap<String, Character> inverseHash = new HashMap<String, Character>();
        // for loop filling up this new hashmap
        for (Map.Entry<Character,String> entry : recursionMap.entrySet()) {
        	// fills it out with the Character, Strings rather than Strings, Characters (its inverse)
        	inverseHash.put(entry.getValue(), entry.getKey());
        }
        // does the decompress method later on
        deCompress("deCompressed", inverseHash);
        
    }
    public void deCompress(String fileName, HashMap<String, Character> hashmap) throws IOException {
    	// input a filename and the name of the hashmap the runner of the code wants
    	FileWriter myFile = new FileWriter(fileName);
    	// sets up the file
    	BufferedBitReader reader1 = new BufferedBitReader("CompressedFile");
    	// buffered bit reader for going through the compressed file
    	String code = "";
    	// start the code off empty and getting ready to fill it up
    	while (reader1.hasNext()) {
    	// gets ready to fill up the file until it has gone through it all	
    		if(!hashmap.containsKey(code)) {
    		// if-statement to look for the specified character	
    			if (reader1.readBit()) {
    				// +1 if it reads the bit
    				code += "1";
    			}
    			else {
    				// +0 if it does not read the bit
    				code += "0";
    			}
    		}
    		else {
    			// once it goes through the whole file it writes the code of the specified character 
    			// and empties the code so that it can do the next character
    			myFile.write(hashmap.get(code));
    			code = "";
    		}
    	}
    	reader1.close();
    	myFile.close();
    	// close both files as we are done with them
    }
    public void gencodes(String code, Branch<Character> branch) {
    	// gencodes with input of code and branch helps with recursion map
    		if (branch.maybeLeaf == true) {
    			// connected to branch method, determines whether it is a leaf (dead end) or not helps with 0's and 1's
    			recursionMap.put(branch.info, code);
    			// if it's a leaf, it adds the code to the recursion map and finishes with a return statement
    			return;
    		}
    	// these two lines use the gencodes I just explained but with "0s" and "1s" to differentiate
    	gencodes(code+"0", branch.branch2);
    	gencodes(code+"1", branch.branch1);
    }
    
    public static void main(String[] args) throws IOException {
    	// main method with throw and runs the indicated file
    	new Compressor("EnglishToArabicDictionary.txt");
    	
       
        
    }
}