package github.kanav;

public class human {
	private int age;
	private char gender;
	
		public void setAge(int age) {
			this.age = age;
		}
		
		public void setGender(char gender) {
			if(gender == 'g') {
				System.out.println("girl");
			}
				else {
				System.out.println("boy");
			}
		}
		
		public void voter() {
			if(age >= 18) {
				System.out.println("you can vote");
			}
			else {
				System.out.println("you cannot vote");
			}
		}
		public void tetanusshot() {
			if (age % 4 == 0) {
				System.out.println("needs tetanus shot");
			}
			else {
				System.out.println("no tetanus shot");
			}
		}
		public void toddler() {
			if(age < 4 && gender == 'g') {
				System.out.println("you are a toddler girl");
			}
			else if(age < 4 && gender == 'b') {
				System.out.println("you are a toddler boy");
			}
			else {
				System.out.println("you are not a toddler");
			}
			
		}
		public void teenager() {
			if (age >= 12 && age <= 18) {
				System.out.println("teen");
			}
			else{
				System.out.println("not a teen");
			}
		}


		public static void main(String[] args) {
			human tester = new human();
			tester.setAge(4);
			tester.setGender('b');
			tester.voter();
			tester.tetanusshot();
			tester.toddler();
			tester.teenager();
	
	}
}
