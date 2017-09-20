package app;

import java.util.ArrayList;

public class Player implements Comparable<Player> {
    private String name;
    private int score;
    private ArrayList<Card> hand;

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
     * @param card The card this player draws
     */
    public void drawCard(Card card) {
        this.hand.add(card);
        this.score += card.getFace();
    }
}
