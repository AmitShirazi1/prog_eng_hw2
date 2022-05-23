public class MultiAddition extends MultiOperations {
    /* represents the multi + expression */

    public MultiAddition(Expression... expressions) {
        this.expressions = new Expression[expressions.length];
        this.expression = 0;
        this.operation = "+";

        int i=0;
        for (Expression expression : expressions) {
            expressions[i++] = expression;
            this.expression += expression.evaluate();
        }
    }

}

