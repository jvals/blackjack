package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    public void testFace() {
        // Test that we can't have a face greater than 13
        assertThrows(IllegalArgumentException.class, () -> {
           new Card(Suit.CLUBS, 15);
        });

        // Test that we can't have a face smaller than 2
        assertThrows(IllegalArgumentException.class, () -> {
            new Card(Suit.DIAMONDS, 1);
        });

        // Test that we can't have a negative face
        assertThrows(IllegalArgumentException.class, () -> {
            new Card(Suit.SPADES, -1);
        });

        // Test that we can set and get a face
        Card nineOfHearts = new Card(Suit.HEARTS, 9);
        assertEquals(9, nineOfHearts.getFace());
    }

    @Test
    public void testSuit() {
        // Test that we can set and get a suit
        Card tenOfDiamonds = new Card(Suit.DIAMONDS,10);
        assertEquals(Suit.DIAMONDS, tenOfDiamonds.getSuit());
    }
}
