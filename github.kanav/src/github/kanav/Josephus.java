package github.kanav;

import java.util.ArrayList;

public class Josephus {
	 
    public static int josephus(int people, int killed) {
//    	ArrayList people1 = new ArrayList<Integer>();
//    	for (int i = 0; i < people; i++)
//    		people1.add(i);
//    	while(people1.size() > 1) {
//    		people1.remove();
//    		
//    		if (i == people1.size()-1) {
//    			i = 0;
//    		}
//    	}
//
//		System.out.println(people1);
//    }
//    public static void main (String[] args) {
//    	josephus(10);
//    }
//}
        if (people == 1)
            return 1;
        else
            return (josephus(people - 1, killed) + killed - 1) % people + 1;
    }
    public static void main(String[] args) {
        int people = 10;
        int killed = 2;
        System.out.println("The chosen place is " + josephus(people, killed));
    }
}
