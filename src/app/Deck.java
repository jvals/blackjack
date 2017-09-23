package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private Card[] deck = new Card[52];
    private int deckPointer = 0;

    public Deck(String rawDeck) {
        parseRawDeck(rawDeck);
    }

    public Deck() {
        fillDeck();
        shuffleDeck();
    }

    public Card[] getDeck() {
        return deck;
    }

    /**
     * Shuffle the card deck
     */
    private void shuffleDeck() {
        ArrayList<Card> temporaryDeck = new ArrayList<>(Arrays.asList(deck));
        Collections.shuffle(temporaryDeck);
        deck = temporaryDeck.toArray(new Card[52]);
    }

    /**
     * This method creates 52 unique cards and stores them in a Card array.
     */
    private void fillDeck() {
        int i = 0;
        for (Suit suit: Suit.values()) {
            for (int face = 1; face <= 13; face++) {
                deck[i] = new Card(suit, face);
                i++;
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
        int i = 0;
        for (String cardString: deckArray) {
            cardString = cardString.trim();

            // Determine number of digits for face
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

            // Determine face
            int newFace = 0;
            switch (second) {
                case "A": newFace = 1; break;
                case "K": newFace = 13; break;
                case "Q": newFace = 12; break;
                case "J": newFace = 11; break;
                default:
                    try {
                        newFace = Integer.parseInt(second);
                    } catch (NumberFormatException e) {
                        System.err.println("The input contained a face which was not recognized: " + second);
                        e.printStackTrace();
                    }
                    break;
            }

            // Create card
            deck[i] = new Card(newSuit, newFace);
            i++;
        }

    }

    /**
     * @return The next card from the top of the deck
     */
    public Card drawCard() {
        if (deckPointer >= 51) {
            throw new RuntimeException("Tried to draw card from empty deck");
        }

        return deck[deckPointer++];
    }
}
