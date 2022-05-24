class Clock {
    static final int BEGINNING_OF_TIME = 0;
    static final int MAX_HOUR = 24;
    static final int MAX_MINUTE_OR_SECOND = 60;
    static final int MINIMAL_2_DIGIT_NUMBER = 10;
    static final String CLOCK_CLASS_NAME = "Clock";


    protected int hour;
    protected int minute;
    protected String class_name;

    public Clock(int hour, int minute) {
        this.hour = (hour < BEGINNING_OF_TIME || hour >= MAX_HOUR) ? BEGINNING_OF_TIME : hour;
        this.minute = (minute < BEGINNING_OF_TIME || minute >= MAX_MINUTE_OR_SECOND) ? BEGINNING_OF_TIME : minute;

       //this.class_name = CLOCK_CLASS_NAME;
    }

    public void setClassName(String name) {
        this.class_name = name;
    }

    @Override
    public boolean equals(Object other_clock) {
        if (this == other_clock) {
            return true;
        }
        if (other_clock == null) {
            return false;
        }

        if (!(other_clock instanceof Clock)) {
            return false;
        }
        Clock other = (Clock) other_clock;
        if ((this.class_name != CLOCK_CLASS_NAME) || (other.class_name != CLOCK_CLASS_NAME)) {
            return false;
        }

        return (this.hour == other.hour && this.minute == other.minute);
    }

    @Override
    public int hashCode(){
        int hour = this.hour;
        int minute = this.minute;
        int hash = (100*hour)+(minute);
        return hash;
    }

    @Override
    public String toString() {
        String hour_str = String.valueOf(this.hour);
        if (this.hour < MINIMAL_2_DIGIT_NUMBER) {
            hour_str = "0" + hour_str;
        }
        String minute_str = String.valueOf(this.minute);
        if (this.minute < MINIMAL_2_DIGIT_NUMBER) {
            minute_str = "0" + minute_str;
        }
        return (hour_str + ":" + minute_str) ;
    }
}

