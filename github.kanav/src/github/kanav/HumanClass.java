package github.kanav;

public class HumanClass {
	private int age;
	private int height;
	private String name;
	
	public HumanClass(int a, int h, String name) {
		age = a;
		height = h;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public int setAge(int newAge) {
		age = newAge;
		return newAge;
	}
	public int getOlder(int change) {
		return age+change;
	}
	public String canVote() {
		if (age > 18) {
			return "You can vote";
		}
		else {
			return "You cannot vote";
		}
	}
	public String changeName(String nameChange) {
		return nameChange;
	}
	public String display() {
		return age + " " + height + " " + name;
	}
	public static void main(String[] args) {
		HumanClass david = new HumanClass (15, 200, "david");
		HumanClass javon = new HumanClass (20, 80, "javon");
		
		System.out.println(david.setAge(20));
// i changed this print statement to test every single possibility
	}
}
