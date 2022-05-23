public abstract class MultiOperations extends Expression {
    /* Operations between numerous numbers */
    protected Expression[] expressions;
    protected String operation;

    public String toString() {
        String multi_expression = "(";

        int j=0;
        for (Expression expression : this.expressions) {
            if (j>=1) {
                multi_expression += this.operation;
            }
            multi_expression += expression.toString();
            j++;
        }

        return multi_expression + ")";
    }
}
