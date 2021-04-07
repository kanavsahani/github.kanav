package github.kanav;

public class GreatAccount extends CreditCard {
	int withdrawls = 0;
	int months = 1;
	public GreatAccount(String owner, double rate) {
		super(owner, rate);
	}
	public GreatAccount(String owner, int money, double rate) {
		super(owner, money, rate);
	}
	public int withdraw(int money) {
		if (withdrawls < 3) {
			super.withdraw(money);
			withdrawls++;
		}
		return getMoney();
		}
	public void nextMonth() {
		if (withdrawls == 0 && months == 12) {
			deposit(getMoney());
		}
		months++;
		withdrawls = 0;
		
	}
}
