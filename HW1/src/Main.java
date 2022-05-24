import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int NUMBER_OF_BOARD_SQUARES = 100;
    static final int FIRST_SQUARE_INDEX = 1;
    static final int INVALID_INPUT_VALUE = 1;
    static final int NO_ERRORS_VALUE = 0;
    static final int MAX_NUMBER_OF_PLAYERS = 5;
    static final int MIN_NUMBER_OF_PLAYERS = 2;


    public static Random rnd;       // Note: Do not change this line.
    public static Scanner scanner;  // Note: Do not change this line.


    public static void main(String[] args) throws IOException {
        String path = args[0];
        scanner = new Scanner(new File(path));
        int numberOfGames = scanner.nextInt();

        for (int i = 1; i <= numberOfGames; i++) {
            int seed = scanner.nextInt();
            rnd = new Random(seed);
            scanner.nextLine();
            String lowerBoundString = scanner.nextLine();

            SnakesAndLaddersGame game;

            if (lowerBoundString.equals("NONE")) {
                game = new SnakesAndLaddersGame();
            } else {
                int lowerBound = Integer.parseInt(lowerBoundString);
                int upperBound = scanner.nextInt();
                scanner.nextLine();
                game = new SnakesAndLaddersGame(lowerBound, upperBound);
            }

            System.out.println("Game number " + i + " starts.");

            game.initializeGame();
            String winner = game.start();
            System.out.println("\n" + winner + " has won the game!");
            System.out.println("Game number " + i + " ended.");
            System.out.println("\n********************************************************************************\n");
        }
        System.out.println("All games are over.");

        // Test two dice
        Die die1 = new Die();
        Die die2 = new Die(21, 3);
    }
}
