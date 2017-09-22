package app;

import java.util.ArrayList;

public class Player implements Comparable<Player> {
    private final String name;
    private int score;
    private final ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    /**
     * @return The player name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The score for this player
     */
    public int getScore() {
        return score;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    /**
     * @param otherPlayer The player to compare this with
     * @return 0 if equal, -1 if this is less than the other, 1 if this is greater than the other
     */
    @Override
    public int compareTo(Player otherPlayer) {
        // Compare player scores
        return Integer.compare(this.score, otherPlayer.score);
    }

    /**
     * @return The cards this player are currently holding
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Print the hand of this player
     */
    public void printHand() {
        StringBuilder output = new StringBuilder();
        for (Card card : hand) {
            output.append(card).append(", ");
        }
        // Remove the last space and comma from the string
        output.delete(output.length() - 2, output.length() - 1);
        System.out.println(output);
    }

    /**
     * Add a card to this players hand
     *
     * @param card The card this player draws
     */
    public void addCard(Card card) {
        this.hand.add(card);
    }
}
