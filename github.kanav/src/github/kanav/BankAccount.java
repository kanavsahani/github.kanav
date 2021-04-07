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
	public double deposit(double money) {
		this.money += money;
		return money;
	}
	public int withdraw(int money) {
		this.money -= money;
		return money;
		
	}
	public int getMoney() {
		return money;
	}
	public String toString() {
		return money + "";
	}
	public double getRate() {
		return rate;
	}
	public static void main(String[] args) {
		GreatAccount sample1 = new GreatAccount("kanav", 100, 0.02);
		GreatAccount sample2 = new GreatAccount("Joel", .01);
		GreatAccount sample3 = new GreatAccount("James", 1000, 1);
		
		sample2.deposit(50);
		System.out.println(sample2);
		
	}
}
