package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void testRank() {
        // Test that we can set and get a rank
        Card nineOfHearts = new Card(Suit.HEARTS, Rank.NINE);
        assertEquals(9, nineOfHearts.getRank().rankValue);
    }

    @Test
    void testSuit() {
        // Test that we can set and get a suit
        Card tenOfDiamonds = new Card(Suit.DIAMONDS,Rank.TEN);
        assertEquals(Suit.DIAMONDS, tenOfDiamonds.getSuit());
    }
}
