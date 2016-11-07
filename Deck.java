import java.util.ArrayList;
import java.util.Random;

class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> usedcard;
	public int nUsed;

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		for (int n = 0; n < nDeck; n++) {
			for (Card.Suit s : Card.Suit.values()) {
				for (int y = 1; y < 14; y++) {
					Card card = new Card(s, y);
					cards.add(card);
				}
			}
		}
	shuffle();	
	}
	
	public void shuffle() {
		usedcard = new ArrayList<Card>();
		Random rnd = new Random();
		for (int i = 0; i < 52; i++) {
			Card c1 = cards.get(i);
			int j = rnd.nextInt(i + 1);
			cards.set(i, cards.get(j));
			cards.set(j, c1);
		}
		nUsed = 0;
	}

	public Card getOneCard() {
		if (nUsed == 52)
			shuffle();
		Card a = cards.get(nUsed);
		usedcard.add(a);
		nUsed++;
		return a;
		
	}

	public void printDeck() {
		for (Card x : cards) {
			x.printCard();
		}

	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}

}