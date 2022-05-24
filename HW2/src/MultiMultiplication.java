public class MultiMultiplication extends MultiOperations {
    /* represents the multi * expression */
    private final static int MINIMAL_OPERAND_NUMBER = 2;

    public MultiMultiplication(Expression... expressions) {
        int number_of_operands = expressions.length;

        if (number_of_operands >= MINIMAL_OPERAND_NUMBER) {
            this.expressions = new Expression[number_of_operands];
        }
        else {
            expressions = new Expression[MINIMAL_OPERAND_NUMBER];
            expressions[0] = new IntegerLiteral(0);
            expressions[1] = new IntegerLiteral(0);;
        }
        this.expression = 1;
        this.operation = " * ";

        int i = 0;
        for (Expression expression : expressions) {
            if (this.expressions != null) {
                this.expressions[i++] = expression;
            }
            this.expression *= expression.evaluate();
        }
    }

}
