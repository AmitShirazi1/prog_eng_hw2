public abstract class ExpressionParser {
    protected boolean is_reverse;
    public Stack stack;

    protected Expression operand1;
    protected Expression operand2;
    protected Expression result;
    protected double operand_double;
    protected int operand_int;

    public abstract Expression parse(String polish_notation);

    public void breakingDownPolishCommand(String current_part_of_command) {
        switch (current_part_of_command) {
            case "+":
                popOutOfStack();
                this.result = new Addition(this.operand1, this.operand2);
                this.stack.push(this.result);
                break;
            case "-":
                popOutOfStack();
                this.result = new Subtraction(this.operand1, this.operand2);
                this.stack.push(this.result);
                break;
            case "*":
                popOutOfStack();
                this.result = new Multiplication(this.operand1, this.operand2);
                this.stack.push(this.result);
                break;
            case "/":
                popOutOfStack();
                this.result = new Division(this.operand1, this.operand2);
                this.stack.push(this.result);
                break;
            case "-u":
                this.operand1 = this.stack.pop();
                this.result = new UnaryMinus(this.operand1);
                this.stack.push(this.result);
                break;
            default:
                // it's a number
                if (current_part_of_command.contains(".")) {
                    this.operand_double = Double.parseDouble(current_part_of_command);
                    this.result = new DoubleLiteral(this.operand_double);
                    this.stack.push(this.result);
                } else {
                    this.operand_int = Integer.parseInt(current_part_of_command);
                    this.result = new IntegerLiteral(this.operand_int);
                    this.stack.push(this.result);
                }
        }
    }

    /**
     * A method defining the operands according to type of Polish Notation (Reverse or regular)
     */
    private void popOutOfStack() {
        if (this.is_reverse) {
            this.operand2 = this.stack.pop();
            this.operand1 = this.stack.pop();
        }
        else {
            this.operand1 = this.stack.pop();
            this.operand2 = this.stack.pop();
        }
    }
}
