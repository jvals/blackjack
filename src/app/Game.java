package app;

class Game {
    private final Deck deck;
    private Player winner = null;
    private final Player player;
    private final Player dealer;

    Game(Deck deck, Player player, Player dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    /**
     * @return The winner of the game
     */
    Player getWinner() {
        if (winner == null) {
            throw new RuntimeException("Winner is yet to be determined");
        }

        return winner;
    }

    void run() {
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

    void drawCard(Player player) {
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

    boolean isTwentyOne(Player player) {
        return (player.getScore() == 21);
    }

    boolean isBust(Player player) {
        return player.getScore() > 21;
    }

    void printResults() {
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
