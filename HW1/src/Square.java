public class Square {
    private Ladder ladder;
    private boolean has_ladder = false;
    private Snake snake;
    private boolean has_snake = false;


    public void addLadder(int ladder_length) {
        this.ladder = new Ladder(ladder_length);
        this.has_ladder = true;
    }

    public void addSnake(int snake_length) {
        this.snake = new Snake(snake_length);
        this.has_snake = true;
    }

    public boolean isTakenByLadderOrSnake(boolean insignificant_difference_we_need_to_address) {
        if (insignificant_difference_we_need_to_address) {
            if (this.has_ladder) { System.out.println("This square already contains a bottom of a ladder!"); }
            else if (this.has_snake) { System.out.println("This square contains a head of a snake!"); }
            else { return false; }
        }

        else {
            if (this.has_ladder) { System.out.println("This square contains a bottom of a ladder!"); }
            else if (this.has_snake) { System.out.println("This square already contains a head of a snake!"); }
            else { return false; }
        }

        return true;
    }
}
//TODO:when doing builder for this class: each square has a square number.