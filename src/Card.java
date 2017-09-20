public class Card {

    private Suit suit;
    private int face;

    /**
     * @param suit The initial suit of the new card object
     * @param face The initial face of the new card object
     */
    public Card(Suit suit, int face) {
        this.suit = suit;
        this.face = face;
    }

    /**
     * @return The suit of this card object
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return The face of this card object
     */
    public int getFace() {
        return face;
    }

}
