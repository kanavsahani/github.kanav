package github.kanav;

public class Card {
	private String suit;
	private int num;
	
	public Card(String s, int n) {
		suit = s;
		num = n;
	}
	public String toString() {
		return suit + ", " + num;
	}
	public String getSuit() {
		return suit;
	}
	public int getNum() {
		return num;
	}
}
