public class RoundedExpression extends NumericalExpressions {
    /* represents the round action.
    * הצגתו של ביטוי אריתמטי מסוג זה מוגדרת להיות הצגה של הביטוי המרכיב את ביטוי העיגול */
    public RoundedExpression (Expression expression, int digits_after_decimal_point){
        this.expression = Math.round(expression.evaluate() * Math.pow(10, digits_after_decimal_point))
                                / Math.pow(10, digits_after_decimal_point);
    }
}
