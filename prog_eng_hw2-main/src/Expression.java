public abstract class Expression {
    public double expression;

    public double evaluate(){
        return this.expression;
    }

    @Override
    public abstract String toString();
}
