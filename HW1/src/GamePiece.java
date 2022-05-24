public class GamePiece {
    private Color piece_color;

    public GamePiece(String color) {
        this.piece_color = Color.valueOf(color.toUpperCase());
    }

    public Color getPieceColor() { return this.piece_color; }


}
