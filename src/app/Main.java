package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // TODO: deck should be an arraylist so we avoid deckpointer. maybe use a queue or dequeue
        // TODO: game.run needs refactoring, everything needs testing
        // TODO: consider removing comparator usage
        // TODO: use maven and improve readme
        // TODO: move some tests from playertest to gametest (the ones that used the old addCard)
        // TODO: fix all warnings
        // TODO: change parsing to work with the actual input style
        // TODO: Card class face output need to include ACE, KING, QUEEN and JACK
        // TODO: Card face values should be enums

        // Read from commandline args
        Deck deck = parseArgs(args);

        // Create player
        Player sam = new Player("Sam");

        // Create dealer
        Player dealer = new Player("Dealer");

        // Create a new game, with the array of cards as input
        Game game = new Game(deck, sam, dealer);

        // Run the game
        game.run();

        // Print results
        game.printResults();

    }

    /**
     * @param args The command line arguments
     * @return An array of cards
     */
    private static Deck parseArgs(String[] args) {
        Deck deck = null;
        switch (args.length) {
            case 0:
                // Create new shuffled deck of cards
                deck = new Deck();
                break;
            case 1:
                // Load deck from input
                String rawDeck = readFile(args[0]);
                deck = new Deck(rawDeck);
                break;
            default:
                // Print usage
                System.out.println("This program takes exactly 0 or 1 command line arguments.\n" +
                        "No argument means 'Create a new shuffled deck of cards'.\n" +
                        "One argument means 'Read a deck of cards from the specified file'."
                );
                System.exit(1);
                break;
        }
        return deck;
    }

    /**
     * @param fileName The name of the input file
     * @return A string of comma separated values representing a deck of cards (A9, KC, 8D, ...)
     */
    private static String readFile(String fileName) {
        String rawDeck = "";
        // Read from specified file
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            rawDeck = buffer.readLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rawDeck;
    }
}
