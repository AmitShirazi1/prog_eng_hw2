public class MultiMultiplication extends MultiOperations {
    /* represents the multi * expression */
    private final static int MINIMAL_OPERAND_NUMBER = 2;
    private Expression[] expressions;

    public MultiMultiplication(Expression... expressions) {
        int number_of_operands = expressions.length;
        if (number_of_operands >= MINIMAL_OPERAND_NUMBER) {
            this.expressions = new Expression[number_of_operands];
            this.expression = 1;
            this.operation = "*";

            int i = 0;
            for (Expression expression : expressions) {
                expressions[i++] = expression;
                this.expression *= expression.evaluate();
            }
        }
        else {
            System.out.println("Not enough operands in this multi-multiplication!");
        }
    }

}
