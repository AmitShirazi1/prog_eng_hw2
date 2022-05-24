public class Division extends ArithmeticOperations{
    /* represents the / sign */

    public Division (Expression first_operand, Expression second_operand){
        this.first_operand = first_operand;
        this.second_operand = second_operand;
        this.operation = " / ";
        this.expression = (double) first_operand.evaluate() / second_operand.evaluate();
    }
}
