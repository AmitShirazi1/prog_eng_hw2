public abstract class NumericalExpressions extends Expression{
    /* an expression constructed of one object that represents a number */
    public String toString() {
        if (this.getClass() == IntegerLiteral.class) {
            return String.format("(%d)", (int) this.expression) ;
        }
        return String.format("(%f)", this.expression) ;
    }
}
