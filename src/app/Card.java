package app;

public class Card {

    private Suit suit;
    private int face;

    /**
     * @param suit The initial suit of the card object
     * @param face The initial face of the card object
     */
    public Card(Suit suit, int face) {
        this.suit = suit;
        setFace(face);
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

    /**
     * @param face The initial face of the card object
     */
    private void setFace(int face) {
        if (face > 10 || face < 2) {
            throw new IllegalArgumentException("Face value must be in the interval [2, 10], was: " + face);
        }

        this.face = face;
    }
}
