package app;

public class Game {
    private Deck deck;
    private Player winner = null;
    private Player player;
    private Player dealer;

    public Game(Deck deck, Player player, Player dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    /**
     * @return The winner of the game
     */
    public Player getWinner() {
        if (winner == null) {
            throw new RuntimeException("Winner is yet to be determined");
        }

        return winner;
    }

    public void run() {
        if (winner != null) {
            throw new RuntimeException("Game already has a winner");
        }
        // All players draw two cards in the beginning
        drawCard(player);
        drawCard(dealer);
        drawCard(player);
        drawCard(dealer);

        // If the player draws 21, they win
        if (isTwentyOne(player)) {
            winner = player;
            return;
        }

        if (isTwentyOne(dealer)) {
            winner = dealer;
            return;
        }

        // If the both the dealer and the player bust, the dealer wins
        if (isBust(dealer) && isBust(player)) {
            winner = dealer;
            return;
        }

        // If only the dealer busts, the player wins
        if (isBust(dealer)) {
            winner = player;
            return;
        }

        // If only the player busts, the dealer wins
        if (isBust(player)) {
            winner = dealer;
            return;
        }

        // Player draw cards until their score is greater than or equal to 17
        while(player.getScore() < 17) {
            drawCard(player);
        }

        if (isBust(player)) {
            winner = dealer;
            return;
        }

        if (isTwentyOne(player)) {
            winner = player;
            return;
        }

        // The dealer draws until their hand is better than the player hand
        while(dealer.getScore() <= player.getScore()) {
            drawCard(dealer);
        }

        if (isBust(dealer)) {
            winner = player;
            return;
        }

        // At this point, the dealer must have a better hand than the player
        winner = dealer;
    }

    public void drawCard(Player player) {
        Card card = deck.drawCard();
        player.addCard(card);

        if (card.getRank() == Rank.ACE) {
            // Ace has the special value of 11 in our game
            player.increaseScore(11);
        } else {
            // Picture cards add 10 to score
            player.increaseScore(Integer.min(card.getRank().rankValue, 10));
        }
    }

    public boolean isTwentyOne(Player player) {
        return (player.getScore() == 21);
    }

    public boolean isBust(Player player) {
        return player.getScore() > 21;
    }

    public void printResults() {
        // Print the name of the winner
        System.out.println(this.getWinner().getName());

        // Print the players hand
        System.out.print(player.getName() + ": ");
        player.printHand();

        // Print the dealers hand
        System.out.print(dealer.getName() + ": ");
        dealer.printHand();
    }
}
