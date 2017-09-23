package app;

class Card {

    private final Suit suit;
    private final Rank rank;

    /**
     * @param suit The initial suit of the card object
     * @param rank The initial rank of the card object
     */
    Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * @return The suit of this card object
     */
    Suit getSuit() {
        return suit;
    }

    /**
     * @return The rank of this card object
     */
    Rank getRank() {
        return rank;
    }


    @Override
    public String toString() {
        return this.suit.shortName + this.rank.shortName;
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
