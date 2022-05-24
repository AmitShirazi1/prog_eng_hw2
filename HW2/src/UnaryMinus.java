public class UnaryMinus extends Expression {
    /* represents the - sign before a number, i.(d).e the additive inverse of the */
    private Expression unary_minus_expression;

    public UnaryMinus (Expression expression) {
        this.unary_minus_expression = expression;
        this.expression = (-1) * expression.evaluate();
    }
    public String toString() {
        return "(-" + this.unary_minus_expression.toString() + ")";
    }
}
