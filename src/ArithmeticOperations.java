public abstract class ArithmeticOperations extends Expression {
    protected Expression first_operand;
    protected Expression second_operand;
    protected String operation;

    public String toString(){
        return "(" + this.first_operand.toString() + this.operation + this.second_operand.toString() + ")";
    }
}
