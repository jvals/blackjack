package app;

public class Card {

    private final Suit suit;
    private int rank;

    /**
     * @param suit The initial suit of the card object
     * @param rank The initial rank of the card object
     */
    public Card(Suit suit, int rank) {
        this.suit = suit;
        setRank(rank);
    }

    /**
     * @return The suit of this card object
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return The rank of this card object
     */
    public int getRank() {
        return rank;
    }

    /**
     * @param rank The initial rank of the card object
     */
    private void setRank(int rank) {
        if (rank > 13 || rank < 1) {
            throw new IllegalArgumentException("Face value must be in the interval [1, 13], was: " + rank);
        }

        this.rank = rank;
    }

    @Override
    public String toString() {
        return this.suit.shortName + String.valueOf(this.rank);
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
        return this.rank == card.rank && this.suit == card.suit;
    }
}
