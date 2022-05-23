public class MultiMultiplication extends MultiOperations {
    /* represents the multi * expression */
    private Expression[] expressions;

    public MultiMultiplication(Expression... expressions) {
        this.expressions = new Expression[expressions.length];
        this.expression = 1;
        this.operation = "*";

        int i=0;
        for (Expression expression : expressions) {
            expressions[i++] = expression;
            this.expression *= expression.evaluate();
        }
    }
}
