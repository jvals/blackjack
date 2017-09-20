package app;

public class Main {

    public static void main(String[] args) {
        // Read from commandline args
        switch (args.length) {
            case 0:
                // Create new shuffled deck of cards
                break;
            case 1:
                // Read from specified file
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
        // Create a new game, with the array of cards as input
        // Run the game
    }
}
