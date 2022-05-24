public abstract class NumericalExpressions extends Expression{
    /* an expression constructed of one object that represents a number */
    public String toString() {
        return String.format("(%f)", this.expression) ;
    }
}
