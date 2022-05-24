public abstract class ArithmeticOperations extends Expression {
    protected Expression first_operand;
    protected Expression second_operand;
    protected String operation;

    public String toString(){
        if ((this.first_operand != null) && (this.operation != null) && (this.second_operand != null)) {
            return "(" + this.first_operand.toString() + this.operation + this.second_operand.toString() + ")";
        }
        return null;
    }
}
