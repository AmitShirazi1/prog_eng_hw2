public class Multiplication extends ArithmeticOperations {
    /* represents the * sign */

    public Multiplication(Expression first_operand, Expression second_operand){
        this.first_operand = first_operand;
        this.second_operand = second_operand;
        this.operation = " * ";
        this.expression = first_operand.evaluate() * second_operand.evaluate();
    }
}
