import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Iterator;

class DealerTest {
	BaccaratDealer dealer;	
	
	@BeforeEach	
	void setup() {
		dealer = new BaccaratDealer();	
	}

	@Test
	void testInitDealer() {
		assertEquals("BaccaratDealer", dealer.getClass().getName(), "Failed to correctly initialize Dealer");		
	}

    @Test
    void testGenerateDeck() {
		dealer.generateDeck();
		ArrayList<Card> deck = dealer.getDeck();
		Iterator<Card> deckItr = deck.iterator();

		String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts"};
		for (int i = 0; i < 4; ++i) {
			for (int j = 1; j <= 13; j++) {
				Card curr = (Card) deckItr.next();
				assertEquals(j, curr.getValue(), "Card has wrong value");
				assertEquals(suits[i], curr.getSuite(), "Card has wrong suite");
			}
		}
	}

	@Test
	void testDealHand() {
		dealer.generateDeck();
		ArrayList<Card> hand = dealer.dealHand();
		Card card1 = (Card) hand.get(0);
		Card card2 = (Card) hand.get(1);
		assertEquals(1, card1.getValue(), "The hand contains unexpected card value");
		assertEquals("Spades", card1.getSuite(), "The hand contains unexpected card suit");
		assertEquals(2, card2.getValue(), "The hand contains unexpected card value");
		assertEquals("Spades", card2.getSuite(), "The hand contains unexpected card suit");
	}
	@Test
	void testDrawOne() {
		dealer.generateDeck();
		int i = dealer.deckSize();
		dealer.drawOne();
		int j = dealer.deckSize();
		assertEquals(51, j, "Card was not removed from deck");
	}

	@Test
	void testShuffle() {
		dealer.generateDeck();
		ArrayList<Card> deck = dealer.getDeck();
		assertTrue(deck.equals(dealer.getDeck()), "getDeck() has issues");
		Boolean OrigDeck = deck.equals(dealer);
		if (OrigDeck) {
			dealer.shuffleDeck();
			assertFalse(deck.equals(dealer), "Did not shuffle the deck");
		}
	}

	@Test
	void testDeckLength() {
		dealer.generateDeck();
		assertEquals(52, dealer.deckSize(), "Wrong deck size");
	}

	@Test
	void testGenNewDeckLen() {
		dealer.generateDeck();
		dealer.shuffleDeck();
		assertEquals(52, dealer.deckSize(), "Wrong deck size");
	}

}
