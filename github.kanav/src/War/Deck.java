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
		public String toString() {
			return ranking + " of " + suit;
		}
		
	}
	public Deck() {
		deck = new LinkedList<Card>();
	
		for (int j = 0; j < suit.length; j++) {
			for (int i = 0; i < ranking.length; i++) {
				deck.add(new Card(suit[j],ranking[i]));
			}
		}
		shuffle();
		split();

		game();
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
		
		while (P2Deck.size() > 0 && deck.size() > 0) {
			System.out.println("\nScore:" + P1Score + "\n");
			System.out.println("Score:" + P2Score + "\n");
			System.out.println(deck.get(0));
			System.out.println(P2Deck.get(0));
			if (deck.get(0).ranking > P2Deck.get(0).ranking) {
				P1Score++;
				deck.add(P2Deck.get(0));
				deck.add(deck.get(0));
				P2Deck.remove(0);
				deck.remove(0);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else if (P2Deck.get(0).ranking > deck.get(0).ranking) {
				P2Score++;
				P2Deck.add(deck.get(0));
				P2Deck.add(P2Deck.get(0));
				deck.remove(0);
				P2Deck.remove(0);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else if (P2Deck.get(0).ranking == deck.get(0).ranking) {
				deck.remove(0);
				P2Deck.remove(0);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		if (deck.size() == 0 || P2Deck.size() == 0) {
			
			if (P1Score > P2Score) {
				System.out.println("\nPlayer 1 Wins! \n");
			}
			if (P2Score > P1Score) {
				System.out.println("\nPlayer 2 Wins! \n");
			}
			if (P1Score == P2Score) {
				System.out.println("\nIt's a Tie! \n");
			}
		}
		
	}
	public static void main (String[] args) {
		new Deck();
	}
	
}