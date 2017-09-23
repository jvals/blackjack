package app;

import java.util.Collections;
import java.util.LinkedList;

class Deck {
    private final LinkedList<Card> deck = new LinkedList<>();

    Deck(String rawDeck) {
        parseRawDeck(rawDeck);
    }

    Deck() {
        fillDeck();
        shuffleDeck();
    }

    LinkedList<Card> getDeck() {
        return deck;
    }

    /**
     * Shuffle the card deck
     */
    private void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    /**
     * This method creates 52 unique cards and stores them in a Card array.
     */
    private void fillDeck() {
        for (Suit suit: Suit.values()) {
            for (Rank rank: Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    /**
     * This method takes a string as input with the following format: "9D, AH, 10D, ..."
     * Every element is converted to a Card object, which is stored in a Card array.
     *
     * @param rawDeck The raw input string loaded from file
     */
    private void parseRawDeck(String rawDeck) {
        String[] deckArray = rawDeck.split(",");
        for (String cardString: deckArray) {
            cardString = cardString.trim();

            // Determine number of digits for rank
            int cardLength = cardString.length();
            String first, second;
            if (cardLength == 2 || cardLength == 3) {
                // The suit is always the first letter
                first = cardString.substring(0, 1);
                second = cardString.substring(1);
            } else {
                throw new IllegalArgumentException("The input contained a corrupt element: " + cardString);
            }

            // Determine suit
            Suit newSuit;
            switch (first) {
                case "D": newSuit = Suit.DIAMONDS; break;
                case "C": newSuit = Suit.CLUBS; break;
                case "H": newSuit = Suit.HEARTS; break;
                case "S": newSuit = Suit.SPADES; break;
                default: throw new IllegalArgumentException("The input contained a suit which was not recognized: "
                        + String.valueOf(first));
            }

            // Determine rank
            Rank newRank;
            switch (second) {
                case "A": newRank = Rank.ACE; break;
                case "2": newRank = Rank.TWO; break;
                case "3": newRank = Rank.THREE; break;
                case "4": newRank = Rank.FOUR; break;
                case "5": newRank = Rank.FIVE; break;
                case "6": newRank = Rank.SIX; break;
                case "7": newRank = Rank.SEVEN; break;
                case "8": newRank = Rank.EIGHT; break;
                case "9": newRank = Rank.NINE; break;
                case "10": newRank = Rank.TEN; break;
                case "J": newRank = Rank.JACK; break;
                case "Q": newRank = Rank.QUEEN; break;
                case "K": newRank = Rank.KING; break;
                default:
                    throw new IllegalArgumentException("The input contained a rank which was not recognized: " + second);
            }

            // Create card
            deck.add(new Card(newSuit, newRank));
        }

    }

    /**
     * @return The next card from the top of the deck
     */
    Card drawCard() {
        if (deck.isEmpty()) {
            throw new RuntimeException("Tried to draw card from empty deck");
        }

        // Get the card on top of the deck, and remove it
        return deck.pollFirst();
    }
}
