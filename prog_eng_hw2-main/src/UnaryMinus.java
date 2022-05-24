public class UnaryMinus extends Expression {
    /* represents the - sign before a number, i.(d).e the additive inverse of the */
    public UnaryMinus (Expression expression) {
        this.expression = (-1) * expression.evaluate();
    }
    public String toString() {
        return String.format("(-(%f))", (- this.expression) ) ;
    }
}
