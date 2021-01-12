package github.kanav;
import java.util.Arrays;

public class WarmUpArrays {

		public void index (int[] nums) {
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i]*i;
				
			}
			System.out.println(sum);
		}
		public void characterCombiner(char[] strings) {
			String str = "";
			for (int i = 0; i < strings.length; i++) {
				if (strings[i] >= 'a' && strings[i] <= 'z') {
					str += strings[i];
				}
			}
			System.out.println(str);
		}
		public void commonCharacter(char[] strings) {
			int previous = strings[0];
		    int popular = strings[0];
		    int count = 1;
		    int maxCount = 1;
			for (int i = 0; i < strings.length; i++) {
				if (strings[i] == previous) {
					count++;
				}
				else {
		            if (count > maxCount) {
		                popular = strings[i-1];
		                maxCount = count;
		            }
		            previous = strings[i];
		            count = 1;
			}
			}
			System.out.println(popular);
		}
	
	
public static void main (String[] args) {
		
		WarmUpArrays run = new WarmUpArrays();
		char[] strings = {'h', 'i', '!', 'H', 'e', 'l', 'L', 'o', '?', 'o'};
		int[] nums = {4,2,6};
		run.index(nums);
		run.characterCombiner(strings);
		run.commonCharacter(strings);
	}
}
