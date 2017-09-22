package app;

public class Card {

    private final Suit suit;
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
        if (face > 13 || face < 1) {
            throw new IllegalArgumentException("Face value must be in the interval [1, 13], was: " + face);
        }

        this.face = face;
    }

    @Override
    public String toString() {
        return this.suit.shortName + String.valueOf(this.face);
    }

    /**
     * @param o The object we are comparing this to
     * @return true if this is the same as the object argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (null == o) {
            return false;
        }
        // type check
        if (getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        // Check fields
        return this.face == card.face && this.suit == card.suit;
    }
}
