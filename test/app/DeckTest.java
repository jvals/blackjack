package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    public void testNewDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.getDeck().length);
        for (int i = 0; i < 52; i++) {
            assertTrue(deck.getDeck()[i].getFace() <= 13);
            assertTrue(deck.getDeck()[i].getFace() >= 1);
            assertTrue(deck.getDeck()[i].getSuit() != null);
        }
    }

    @Test
    public void testLoadDeck() {
        String rawDeck = "9D, 5H, KC, 10D, QC, AC, 2C, KH, 6H, JS, 7H, QD, 5C," +
                " 4C, JH, 8C, 7S, 6S, AS, 8H, 4D, QS, 9H, KD, 10S, 7C," +
                " 5D, JD, 9C, 4H, JC, KS, 8D, 3D, QH, 2S, AD, 9S, 10C," +
                " 3C, 4S, 8S, 7D, 3S, 3H, AH, 6C, 2D, 6D, 2H, 5S, 10H";
        Deck deck = new Deck(rawDeck);
        assertNotNull(deck.getDeck());
        assertEquals(52, deck.getDeck().length);
        assertEquals(Suit.DIAMONDS, deck.getDeck()[0].getSuit());
        assertEquals(9, deck.getDeck()[0].getFace());
    }
}