public class RoundedExpression extends Expression {
    /* represents the round action.
    * הצגתו של ביטוי אריתמטי מסוג זה מוגדרת להיות הצגה של הביטוי המרכיב את ביטוי העיגול */
    public double value_before_round;

    public RoundedExpression (Expression expression, int digits_after_decimal_point){
        this.value_before_round = expression.evaluate();
        this.expression = Math.round(this.value_before_round * Math.pow(10, digits_after_decimal_point))
                                / Math.pow(10, digits_after_decimal_point);
    }

    public String toString() {
        return String.format("(%f)", this.value_before_round);
    }
}
