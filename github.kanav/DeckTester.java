import java.util.Scanner;

public class DeckTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deck deck = new DeckArray();
		while (true) {
			System.out.println("Type 'sort', 'shuffle', 'first', 'random', or 'quit'");
			String choice = in.next();
			switch (choice) {
			case ("sort"):
				deck.sort();
				deck.display();
				break;
			case("shuffle"):
				deck.shuffle();
				deck.display();
				break;
			case("first"): 
				System.out.println("Enter how many cards you want from the top");
				int n = in.nextInt();
				for (Card c: deck.getFirstN(n))
					c.print();
				break;
			case("random"):
				deck.getRandom().print();
				break;
			case("quit"):
				return;
			}
		}
	}
}
