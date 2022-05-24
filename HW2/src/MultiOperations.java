public abstract class MultiOperations extends Expression {
    /* Operations between numerous numbers */
    protected Expression[] expressions;
    protected String operation;

    public String toString() {
        String multi_expression = "(";
        int i=0;
        if (this.expressions != null) {
            for (Expression expression : this.expressions) {
                if (i>0) {
                    multi_expression = multi_expression.concat(this.operation);
                }
                if (expression != null) {
                    multi_expression = multi_expression.concat(expression.toString());
                }
                i++;
            }
            return multi_expression + ")";
        }
        return null;
    }
}
