package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player testPlayer;
    private String testName;

    @BeforeEach
    void setUp() {
        testName = "Joe";
        testPlayer = new Player(testName);
    }

    @Test
    void getName() {
        // The name should be set after construction
        assertEquals(testName, testPlayer.getName());
    }

    @Test
    void getScore() {
        // The initial score should be 0
        assertEquals(0, testPlayer.getScore());
    }

    @Test
    void getHandAndDrawCard() {
        // The initial hand should be empty
        assertEquals(0, testPlayer.getHand().size());

        // After drawing some cards, the score should be non-zero
        Rank firstRank = Rank.TWO;
        Rank secondRank = Rank.THREE;

        testPlayer.addCard(new Card(Suit.DIAMONDS, firstRank));
        testPlayer.increaseScore(firstRank.rankValue);

        testPlayer.addCard(new Card(Suit.CLUBS, secondRank));
        testPlayer.increaseScore(secondRank.rankValue);

        assertTrue(testPlayer.getHand().size() == 2);
        assertEquals(firstRank.rankValue + secondRank.rankValue, testPlayer.getScore());
    }

    @Test
    void compareTo() {
        Player opponent = new Player("Dan");

        // The players draw one card each with equal value
        Rank testRank = Rank.FIVE;
        opponent.addCard(new Card(Suit.CLUBS, testRank));
        opponent.increaseScore(testRank.rankValue);
        testPlayer.addCard(new Card(Suit.SPADES, testRank));
        testPlayer.increaseScore(testRank.rankValue);

        // Assert that these players are equal
        assertTrue(testPlayer.compareTo(opponent) == 0);

        testPlayer.addCard(new Card(Suit.CLUBS, testRank));
        testPlayer.increaseScore(testRank.rankValue);

        // Assert that Joe now has a higher score
        assertTrue(testPlayer.compareTo(opponent) > 0);

    }

}