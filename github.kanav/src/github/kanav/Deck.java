package github.kanav;


public class Deck {
	private Card[] cardDeck; 
	
	public Deck() {
		String [] suit = {"club", "spade", "heart", "diamond"};
		this.cardDeck = new Card[52];
		int count1 = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14; j++) {
				cardDeck[count1] = new Card(suit[i], j);
				count1++;
			}
		}
	}
	
	public String toString() {
		String count = "";
		for (int i = 0; i < cardDeck.length; i++) {
			count += cardDeck[i] + " ";
		}
		return(count);
	}
	public String getRandom() {
		int rnd = (int) ((Math.random()*52) + 0);
		return cardDeck[rnd] + "";
	}
	public Card[] getFirstN(int n) {
		Card[] count = new Card[n];
		for (int i = 0; i < n; i++) {
			count[i] = cardDeck[i];
		}
		return count;
	}
	public void shuffle() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < cardDeck.length; j++) {
				int random = (int)(Math.random()*cardDeck.length);
				Card temp = cardDeck[random];
				cardDeck[random] = cardDeck[i];
				cardDeck[i] = temp;
			}
		}
	}
	public void sort() {
		String [] suit = {"club", "spade", "heart", "diamond"};
		this.cardDeck = new Card[52];
		int count1 = 0;
		for (int j = 1; j < 14; j++) {
			for (int i = 0; i < 4; i++) {
				cardDeck[count1] = new Card(suit[i], j);
				count1++;
			}
		}
	}
	
}
