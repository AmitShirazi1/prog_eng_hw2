class AccurateClock extends Clock {
    static final String ACCURATE_CLOCK_CLASS_NAME = "AccurateClock";

    private int second;

    public AccurateClock(int hour, int minute, int second) {
        super(hour, minute);
        this.second = (second < super.BEGINNING_OF_TIME || second >= super.MAX_MINUTE_OR_SECOND) ? super.BEGINNING_OF_TIME : second;
        super.setClassName(CLOCK_CLASS_NAME);
    }

    @Override
    public boolean equals(Object other_accurate_clock) {
        if (this == other_accurate_clock) {
            return true;
        }
        if (other_accurate_clock == null) {
            return false;
        }

        if (!(other_accurate_clock instanceof AccurateClock)) {
            return false;
        }
        AccurateClock other = (AccurateClock) other_accurate_clock;
        if ((this.class_name != ACCURATE_CLOCK_CLASS_NAME) || (other.class_name != ACCURATE_CLOCK_CLASS_NAME)) {
            return false;
        }

        return (this.hour == other.hour && this.minute == other.minute && this.second == other.second);
    }

    @Override
    public int hashCode(){
        int hour = this.hour;
        int minute = this.minute;
        int second = this.second;
        int hash = (10000*hour)+(100*minute)+(second);
        return hash;

    }

    @Override
    public String toString() {
        String seconds_str = String.valueOf(this.second);
        if (this.second < super.MINIMAL_2_DIGIT_NUMBER) {
            seconds_str = "0" + seconds_str;
        }
        return (super.toString() + ":" + seconds_str) ;
    }
}