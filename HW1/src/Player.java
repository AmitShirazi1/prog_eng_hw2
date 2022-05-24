public class Player {
    private String player_name;
    private GamePiece player_piece;
//    private int number_of_players = 0;

    public Player(String name, String color) {
        this.player_name = name;
        this.player_piece = new GamePiece(color);
        //this.number_of_players += 1;
    }

    public String getName(){
        return this.player_name;
    }
    public Color getPlayerColor() { return this.player_piece.getPieceColor(); }
    //public int getNumberOfPlayers() { return this.number_of_players; }


    public boolean isNameTaken(Player other_player) {
        if(this.player_name.equals(other_player.player_name)) {
            return true;
        }
        return false;
    }


    public boolean isColorTaken(Player other_player) {
        if(this.getPlayerColor().equals(other_player.getPlayerColor())) {
            return true;
        }
        return false;
    }


    // returns true = not a valid new player , false = player is valid and we may go on
    public boolean isNameAndColorTaken(Player other_player) {
        boolean name = this.isNameTaken(other_player);
        boolean color = this.isColorTaken(other_player);

        if (name && color) { System.out.println("The name and the color are already taken!"); }
        else if (name && !color) { System.out.println("The name is already taken!"); }
        else if (!name && color) { System.out.println("The color is already taken!"); }
        else { return false; }

        return true;
    }
}
