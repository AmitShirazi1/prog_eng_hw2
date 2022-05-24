import java.util.Random;

public class Die {
    private int start_of_range;
    private int end_of_range;

    public Die(int start_of_range,int end_of_range){
        this.start_of_range=start_of_range;
        this.end_of_range=end_of_range;
    }
    public Die(){
        this(1,6);
    }


    private int roll() {
        int new_end;
        if (this.start_of_range < 0) {
            new_end = this.end_of_range - this.start_of_range;
        } else {
            new_end = this.end_of_range;
        }
        int rnd_num = Main.rnd.nextInt(new_end+1);
        return this.start_of_range<0 ? (rnd_num + this.start_of_range) : (rnd_num);   //if start_of_range is Negative normalize the random number generated
    }                                                                                //back to the starting point. o.w. return the randomized number only

}
