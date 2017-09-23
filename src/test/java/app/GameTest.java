package app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
  private Game game;
  private Player player;
  private Player dealer;

  @BeforeEach
  void setUp() {
    String rawDeck =
        "CA, D5, H9, HQ, S8, D9, H5, CK, D10, CQ, C2, HK, H6, "
            + "SJ, H7, DQ, C5, C4, HJ, C8, S7, S6, SA, H8, D4, SQ, "
            + "DK, S10, C7, DJ, C9, H4, CJ, SK, D8, D3, S2, DA, S9, "
            + "C10, C3, S4, D7, S3, H3, HA, C6, D2, D6, H2, S5, H10";
    Deck deck = new Deck(rawDeck);
    player = new Player("Player");
    dealer = new Player("Dealer");
    game = new Game(deck, player, dealer);
  }

  @Test
  void getWinner() {
    game.run();

    // Assert that the player is the winner
    assertEquals(player, game.getWinner());
  }

  @Test
  void run() {
    game.run();

    // Assert the player score and dealer score
    assertEquals(20, player.getScore());
    assertEquals(23, dealer.getScore());

    // Assert that we can't run the game more than once.
    assertThrows(RuntimeException.class, () -> game.run());
  }

  @Test
  void drawCard() {
    game.drawCard(dealer);
    game.drawCard(player);
    game.drawCard(player);
    game.drawCard(dealer);
    Card[] expectedDealerHand = {new Card(Suit.CLUBS, Rank.ACE), new Card(Suit.HEARTS, Rank.QUEEN)};
    Card[] expectedPlayerHand = {
      new Card(Suit.DIAMONDS, Rank.FIVE), new Card(Suit.HEARTS, Rank.NINE)
    };

    // Assert that cards are drawn correctly from the deck
    assertArrayEquals(dealer.getHand().toArray(), expectedDealerHand);
    assertArrayEquals(player.getHand().toArray(), expectedPlayerHand);
  }

  @Test
  void isTwentyOne() {
    player.increaseScore(21);
    assertTrue(game.isTwentyOne(player));
    assertFalse(game.isTwentyOne(dealer));
  }

  @Test
  void isBust() {
    player.increaseScore(22);
    assertTrue(game.isBust(player));
    assertFalse(game.isBust(dealer));
  }

  @Test
  void printResults() {
    assertThrows(RuntimeException.class, () -> game.printResults());
    game.run();

    // Redirect stdout to PrintStream
    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    game.printResults();
    assertEquals("Player\nPlayer: CA, H9\nDealer: D5, HQ, S8\n", output.toString());

    // Reset stdout
    System.setOut(null);
  }
}
