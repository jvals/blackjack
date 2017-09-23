package app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    public void testNewDeck() {
        Deck deck = new Deck();
        assertEquals(52, deck.getDeck().length);
        for (int i = 0; i < 52; i++) {
            assertTrue(deck.getDeck()[i].getRank().rankValue <= 13);
            assertTrue(deck.getDeck()[i].getRank().rankValue >= 1);
            assertTrue(deck.getDeck()[i].getSuit() != null);
        }
    }

    @Test
    public void testLoadDeck() {
        String rawDeck =
                "D9, H5, CK, D10, CQ, CA, C2, HK, H6, SJ, H7, DQ, C5, " +
                "C4, HJ, C8, S7, S6, SA, H8, D4, SQ, H9, DK, S10, C7, " +
                "D5, DJ, C9, H4, CJ, SK, D8, D3, HQ, S2, DA, S9, C10, " +
                "C3, S4, S8, D7, S3, H3, HA, C6, D2, D6, H2, S5, H10";
        Deck deck = new Deck(rawDeck);
        assertNotNull(deck.getDeck());
        assertEquals(52, deck.getDeck().length);
        assertEquals(Suit.DIAMONDS, deck.getDeck()[0].getSuit());
        assertEquals(Rank.NINE, deck.getDeck()[0].getRank());
    }
}