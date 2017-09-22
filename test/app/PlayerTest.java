package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
        Random generator = new Random();
        int first = generator.nextInt(13) + 1;
        int second = generator.nextInt(13) + 1;
        testPlayer.addCard(new Card(Suit.DIAMONDS, first));
        testPlayer.increaseScore(first);
        testPlayer.addCard(new Card(Suit.CLUBS, second));
        testPlayer.increaseScore(second);
        assertTrue(testPlayer.getHand().size() == 2);
        assertEquals(first + second, testPlayer.getScore());
    }

    @Test
    void compareTo() {
        Player opponent = new Player("Dan");

        // The players draw one card each with equal value
        opponent.addCard(new Card(Suit.CLUBS, 5));
        opponent.increaseScore(5);
        testPlayer.addCard(new Card(Suit.SPADES, 5));
        testPlayer.increaseScore(5);

        // Assert that these players are equal
        assertTrue(testPlayer.compareTo(opponent) == 0);

        testPlayer.addCard(new Card(Suit.CLUBS, 5));
        testPlayer.increaseScore(5);

        // Assert that Joe now has a higher score
        assertTrue(testPlayer.compareTo(opponent) > 0);

    }

}