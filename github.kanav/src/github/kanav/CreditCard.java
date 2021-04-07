package github.kanav;

public class CreditCard extends BankAccount{

	public CreditCard(String owner, double rate) {
		super(owner, rate);
	}
	public CreditCard(String owner, int money, double rate) {
		super(owner, money, rate);
	}
	
	public void interestAdder() {
		addInterest();
		withdraw(10); 
		
		
	}
	public int withdraw(int money) {
		if (getMoney() < 100) {
		}
		else {
			super.withdraw(money);
		}
		return getMoney();
	}
	public double addInterest() {
		deposit(getMoney()*getRate());
		return getMoney();
	}
}
