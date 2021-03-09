package github.kanav;

public class BankAccount {
	private String owner;
	private int money;
	private double rate;
	
	public BankAccount (String owner, int money, double rate) {
		this.owner = owner;
		this.money = money;
		this.rate = rate;
	}
	public BankAccount (String owner, double rate) {
		this.owner = owner;
		this.rate = rate;
	}
	public int deposit(int money) {
		this.money += money;
		return money;
	}
	public int withdraw(int money) {
		this.money -= money;
		return money;
	}
	public double addInterest() {
		money += (money*rate);
		return money;
	}
	public String toString() {
		return money + "";
	}
	public static void main(String[] args) {
		BankAccount sample1 = new BankAccount("kanav", 100, 0.02);
		BankAccount sample2 = new BankAccount("Joel", .01);
		BankAccount sample3 = new BankAccount("James", 1000, 1);
		
		sample3.addInterest();
		System.out.println(sample3);
		
	}
}
