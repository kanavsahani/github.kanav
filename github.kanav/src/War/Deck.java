package War;
import LinkedList.LinkedList;

public class Deck {
	private String[] suit = {"Spades","Hearts","Diamonds", "Clubs"};
	private int[] ranking = {2,3,4,5,6,7,8,9,10,11,12,13,14};
	public LinkedList<Card> deck, P2Deck;
	public int P1Score;
	public int P2Score;
	
	public class Card {
		public String suit;
		public int ranking;
		
		public Card(String suit,int ranking) {
			this.suit = suit;
			this.ranking = ranking;
		}
		
	}
	public Deck() {
		deck = new LinkedList<Card>();
	
		for (int j = 0; j < suit.length; j++) {
			for (int i = 0; i < ranking.length; i++) {
				deck.add(new Card(suit[j],ranking[i]));
			}
		}
//		shuffle();

		split();		System.out.println("size: " + P2Deck.size());

		for (int i = 0; i < 26; i++) {
			System.out.println(P2Deck.get(i).ranking);
		}
	}
	public void shuffle() {

		for (int i = 0; i < 52; i++) {
			int shuf = (int) ((Math.random()*52));
			Card temp = deck.remove(shuf);
			deck.add(temp);
		}
	}
	public void split() {
		P2Deck = new LinkedList<Card>();
		while(deck.size() > 26) {
			P2Deck.add(deck.remove(0));
		}
		
	}
	
	public void game() {
		
		for (int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i));
			System.out.println(P2Deck.get(i));
			if (deck.get(i).ranking > P2Deck.get(i).ranking) {
				P1Score++;
				deck.add(P2Deck.get(i));
				P2Deck.remove(i);
			}
			if (P2Deck.get(i).ranking < deck.get(i).ranking) {
				P2Score++;
				P2Deck.add(deck.get(i));
				deck.remove(i);
			}
		}
		if (deck.size() == 0 || P2Deck.size() == 0) {
			
			if (P1Score > P2Score) {
				System.out.println("Player 1 Wins!");
			}
			if (P2Score > P1Score) {
				System.out.println("Player 2 Wins!");
			}
		}
		System.out.println("Score:" + P1Score);
		System.out.println("Score:" + P2Score);
	}
	public static void main (String[] args) {
		new Deck();
	}
	
}

