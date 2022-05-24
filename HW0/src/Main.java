import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner;  // Note: Do not change this line.

    static final int MAX_SEMESTERS = 1000;
    static final int NON_VALID_INDEX = -1;
    static final int NUM_OF_ROWS_INDEX = 0;
    static final int NUM_OF_COLUMNS_INDEX = 1;
    static final int SIZE_OF_BOARD_DATA = 2;


    public static void theStudentsGame() {
        /** getting board's dimensions, initialize board with 0's. */
        int[] boardParameters = new int[SIZE_OF_BOARD_DATA];
        setBoardSize(boardParameters);
        boolean[][] board = new boolean[boardParameters[NUM_OF_ROWS_INDEX]][boardParameters[NUM_OF_COLUMNS_INDEX]];
        boolean[][] tempArray = new boolean[boardParameters[NUM_OF_ROWS_INDEX]][boardParameters[NUM_OF_COLUMNS_INDEX]];

        /** Scanning first round data from the president. */
        presidentsChoice(tempArray, boardParameters);

        int semester = 1, i, j;
        boolean isBreak;

        while (true) {
            isBreak = false;
            //Start of a round in the game:
            if (semester > 1) {
                gamePlay(board, tempArray, boardParameters);
            }

            for (i = 0; i < boardParameters[NUM_OF_ROWS_INDEX]; i++) {          //Checking if the board is not "empty".
                for (j = 0; j < boardParameters[NUM_OF_COLUMNS_INDEX]; j++) {
                    if (tempArray[i][j] == true) {
                        isBreak = true;
                        break;
                    }
                }
                if (isBreak == true) {
                    break;
                }
            }
            if (isBreak == false) {
                printGameRound(tempArray, semester, boardParameters);
                System.out.println("There are no more students.");
                break;  // end of game
            }

            if (compareArrays(board, tempArray, boardParameters) == false) {
                System.out.println("The students have stabilized.");
                break; // end of game
            }
            else if (semester == MAX_SEMESTERS) {
                System.out.println("The semesters limitation is over.");
                break; // end of game
            }

            copyArrays(board, tempArray, boardParameters);
            //System.out.println("Copy works");

            //Printing round results:
            printGameRound(board, semester, boardParameters);
            semester += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        scanner = new Scanner(new File(path));
        int numberOfGames = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfGames; i++) {
            System.out.println("Game number " + i + " starts.");
            theStudentsGame();
            System.out.println("Game number " + i + " ended.");
            System.out.println("-----------------------------------------------");
        }
        System.out.println("All games are ended.");
    }

    /**
     * Asks president for board's dimensions,
     * then saves it in an array for later use.
     * @param boardParameters keeps the size of the game board.
     */
    public static void setBoardSize(int[] boardParameters) {
        System.out.println("Dear president, please enter the board’s size.");
        String input = scanner.nextLine();
        String[] boardSizeStr = input.split(" X ");
        boardParameters[NUM_OF_ROWS_INDEX] = Integer.parseInt(boardSizeStr[0]);
        boardParameters[NUM_OF_COLUMNS_INDEX] = Integer.parseInt(boardSizeStr[1]);
    }

    /**
     * Preparations for 1st semester,
     * president chooses proper \ not proper students.
     * @param tempArray stores the initial data imported by the user and the updated data throughout the game.
     * @param boardParameters keeps the size of the game board.
     */
    public static void presidentsChoice(boolean[][] tempArray, int[] boardParameters) {
        String input;
        int validStudentRow = NON_VALID_INDEX;
        int validStudentColumn = NON_VALID_INDEX;
        boolean outOfBound = false;
        while (true) {
            if (outOfBound==false) {
                System.out.println("Dear president, please enter the cell’s indexes.");
            }
            input = scanner.nextLine();
            if (input.equals("Yokra") || input.isEmpty()) {
                break;
            }
            String[] validStudentIndexes = input.split(", ");
            validStudentRow = Integer.parseInt(validStudentIndexes[0]);
            validStudentColumn = Integer.parseInt(validStudentIndexes[1]);
            if (validStudentRow < 0 || validStudentRow >= boardParameters[NUM_OF_ROWS_INDEX]
                    || validStudentColumn < 0 || validStudentColumn >= boardParameters[NUM_OF_COLUMNS_INDEX]) {
                System.out.println("The cell is not within the board’s boundaries, enter a new cell.");
                outOfBound = true;
                continue;
            }
            changeAcademicStatus(tempArray[validStudentRow][validStudentColumn], tempArray, validStudentRow, validStudentColumn);
        }
    }

    /**
     * Checks around each student if their friends are proper/ not proper,
     * then counts the proper students and checks if they should change their status.
     * @param board stores initial and final data before printing it.
     * @param tempArray stores the initial data imported by the user and the updated data throughout the game.
     * @param boardParameters keeps the size of the game board.
     */
    public static void gamePlay(boolean[][] board, boolean[][] tempArray, int[] boardParameters) {
        int counter;
        for (int i = 0; i < boardParameters[NUM_OF_ROWS_INDEX]; i++) {
            for (int j = 0; j < boardParameters[NUM_OF_COLUMNS_INDEX]; j++) {
                counter=0;
                for (int rowFriend = i-1; rowFriend < i+2; rowFriend++) {       // Checking around current student.
                    if (rowFriend < 0 ||  rowFriend >= boardParameters[NUM_OF_ROWS_INDEX]) {         // If out of bound.
                        continue;
                    }
                    for (int columnFriend = j-1; columnFriend < j+2; columnFriend++) {
                        if (columnFriend < 0 ||  columnFriend >= boardParameters[NUM_OF_COLUMNS_INDEX]) {         // If out of bound.
                            continue;
                        }
                        if (board[rowFriend][columnFriend] == true) {
                            counter++;
                        }
                    }
                }
                shouldChangeStatus(board[i][j], tempArray, counter, i, j);
            }
        }

    }

    /**
     * Changes student's academic status according to a set of given conditions.
     * @param student boolean parameter indicating if the student is academically proper or not.
     * @param tempArray stores the initial data imported by the user and the updated data throughout the game.
     * @param counter counts the number of academically proper students.
     * @param i row of the student being checked.
     * @param j column of the student being checked.
     */
    public static void shouldChangeStatus(boolean student, boolean[][] tempArray, int counter, int i, int j) {
        if (student == true) {   // If current student being checked is T.
            counter--;  // excluding current student being checked.

            if (counter <= 1 || counter > 3) {
                changeAcademicStatus(student, tempArray, i, j);// change current student's academic status to False.

            }
        }
        else if (counter == 3) {    // If current student being checked is F.
            changeAcademicStatus(student, tempArray, i, j);    // change current student's academic status to True.
        }

    }

    /**
     * Copies the values of an array from a given source array to a given destination array.
     * @param dest destination array to copy data to from source array.
     * @param src source array to copy data from to the destination array.
     * @param boardParameters keeps the size of the game board.
     */
    public static void copyArrays(boolean[][] dest, boolean[][] src, int[] boardParameters) {
        for (int i = 0; i < boardParameters[NUM_OF_ROWS_INDEX]; i++) {
            System.arraycopy(src[i], 0, dest[i], 0, boardParameters[NUM_OF_COLUMNS_INDEX]);
        }
    }

    /**
     *Prints the game board to the user
     *In addition counts and prints the number of academically proper students.
     * @param board stores initial and final data before printing it.
     * @param semester counts number of rounds between 0 and 1000.
     * @param boardParameters keeps the size of the game board.
     */
    public static void printGameRound(boolean[][] board, int semester, int[] boardParameters) {
        System.out.println("Semester number " + semester + ":");
        int goodStudentsNumber = 0;
        for (int i = 0; i < boardParameters[NUM_OF_ROWS_INDEX]; i++) {
            for (int j = 0; j < boardParameters[NUM_OF_COLUMNS_INDEX]; j++) {
                if (board[i][j] == true) {
                    goodStudentsNumber++;
                    System.out.print('▮');
                } else {
                    System.out.print('▯');
                }
            }
            System.out.println();
        }
        System.out.println("Number of students: " + goodStudentsNumber);
        System.out.println();
    }

    /**
     * Compares the value of two given arrays
     *      * Returns true value if there's any difference.
     * @param arr1 an array to compare cells with arr2.
     * @param arr2 an array to compare cells with arr1.
     * @param boardParameters keeps the size of the game board.
     * @return if there is a difference between arr1 and arr2 the function returns true value.
     */

    public static boolean compareArrays(boolean[][] arr1, boolean[][] arr2, int[] boardParameters){
        for (int i = 0; i < boardParameters[NUM_OF_ROWS_INDEX]; i++) {
            for (int j = 0; j < boardParameters[NUM_OF_COLUMNS_INDEX]; j++) {
                if (arr1[i][j] != arr2[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Changes the academic status of a given student according to their previous status.
     * @param isProper a parameter that is true if a student is academically proper.
     * @param array the board of the game being played.
     * @param i row of the student being checked.
     * @param j column of the student being checked.
     */
    public static void changeAcademicStatus(boolean isProper, boolean[][] array, int i, int j) {
        if (isProper == false) {
            array[i][j] = true;
        } else {
            array[i][j] = false;
        }
    }
}
