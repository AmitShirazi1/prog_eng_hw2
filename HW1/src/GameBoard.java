public class GameBoard {
    private Square[] board = new Square[Main.NUMBER_OF_BOARD_SQUARES];

    public GameBoard() {
        for (int i=Main.FIRST_SQUARE_INDEX; i<=Main.NUMBER_OF_BOARD_SQUARES; i++) {
            this.board[i] = new Square();
        }
    }

    public Square getSquare(int index) { return this.board[index]; }
}
