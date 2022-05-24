public class SnakesAndLaddersGame {
    private Die die;
    private GameBoard game_board;

    public SnakesAndLaddersGame(int lower_die_bound, int upper_die_bound){
        //constructor method here
        this.die = new Die(lower_die_bound, upper_die_bound);
        this.game_board = new GameBoard();
    }

    public SnakesAndLaddersGame(){
       this(1,6);
    }


    public int initializePlayers(String[] command_segments, Player[] players, int player_count, boolean is_taken) {
        if (player_count >= Main.MAX_NUMBER_OF_PLAYERS) {
            System.out.println("The maximal number of players is five!");
            return Main.INVALID_INPUT_VALUE;
        }

        Player temp_player = new Player(command_segments[2], command_segments[3]);

        for(int i = 0; !is_taken && (i < player_count); i++) {
            is_taken = temp_player.isNameAndColorTaken(players[i]);
        }
        if (is_taken) {
            return Main.INVALID_INPUT_VALUE;
        }

        players[player_count] = temp_player; // if the player is legit, we can add him\her to the players array

        return Main.NO_ERRORS_VALUE;
    }


    public int settingLadders(int ladder_length, int square_index) {
        if ( (square_index < 1) || (square_index > Main.NUMBER_OF_BOARD_SQUARES) ) {
            System.out.println("The square is not within the board's boundaries!");
            return Main.INVALID_INPUT_VALUE;
        }
        if ((square_index + ladder_length) > Main.NUMBER_OF_BOARD_SQUARES) {
            System.out.println("The ladder is too long!");
            return Main.INVALID_INPUT_VALUE;
        }

        Square current_square = this.game_board.getSquare(square_index);
        if (current_square.isTakenByLadderOrSnake(true)) {
            return Main.INVALID_INPUT_VALUE;
        }

        current_square.addLadder(ladder_length);
        return Main.NO_ERRORS_VALUE;
    }


    public int settingSnakes(int snake_length, int square_index) {
        if ( (square_index < Main.FIRST_SQUARE_INDEX) || (square_index > Main.NUMBER_OF_BOARD_SQUARES) ) {
            System.out.println("The square is not within the board's boundaries!");
            return Main.INVALID_INPUT_VALUE;
        }
        if (square_index == Main.NUMBER_OF_BOARD_SQUARES) {
            System.out.println("You cannot add a snake in the last square!");
            return Main.INVALID_INPUT_VALUE;
        }
        if ((square_index - snake_length) < Main.FIRST_SQUARE_INDEX) {
            System.out.println("The snake is too long!");
            return Main.INVALID_INPUT_VALUE;
        }

        Square current_square = this.game_board.getSquare(square_index);
        if (current_square.isTakenByLadderOrSnake(false)) {
            return Main.INVALID_INPUT_VALUE;
        }

        current_square.addSnake(snake_length);

        return Main.NO_ERRORS_VALUE;
    }


    public void initializeGame(){
        String[] command_segments;
        Player[] players = new Player[Main.MAX_NUMBER_OF_PLAYERS];
        int player_count = 0;

        while(true) {
            String input = Main.scanner.nextLine();
            if (input.equals("end")) {
                if (player_count < Main.MIN_NUMBER_OF_PLAYERS) {
                    System.out.println("Cannot start the game, there are less than two players!");
                    continue;
                }
                break;
            }

            command_segments = input.split(" ");


            if (command_segments[1].equals("player")) {
                if (this.initializePlayers(command_segments, players, player_count, false)
                        == Main.INVALID_INPUT_VALUE) {
                    continue;
                }
                player_count += 1;
            }

            else if (command_segments[1].equals("ladder")) {
                if (this.settingLadders(Integer.parseInt(command_segments[2]), Integer.parseInt(command_segments[3]))
                        == Main.INVALID_INPUT_VALUE) {
                    continue;
                }
            }

            else if (command_segments[1].equals("snake")) {
                if (this.settingSnakes(Integer.parseInt(command_segments[2]), Integer.parseInt(command_segments[3]))
                        == Main.INVALID_INPUT_VALUE) {
                    continue;
                }
            }

        }
    }

/*    public String start() {
        return winner_name;
    }
     בנוסף, שימו לב כי לא קיים איסור על הוספה של סולם למשבצת הראשונה של לוח המשחק. עם
זאת, במידה וסולם כזה אכן קיים, השחקנים יטפסו במעלו רק במידה ויגיעו למשבצת הראשונה במהלך המשחק ולא
בתחילתו */
}



