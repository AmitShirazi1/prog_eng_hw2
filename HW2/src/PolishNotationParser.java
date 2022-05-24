/**
 *
 */
public class PolishNotationParser extends ExpressionParser {
    public PolishNotationParser() {
        this.is_reverse = false;
    }

    public Expression parse(String polish_notation) {
        //Stack to store operands
        this.stack = new Stack();
        String[] polish_command = polish_notation.split(" ");
        int expression_length = polish_command.length;

        //Parse the expression - right to left
        for (int i = expression_length-1; i >= 0; i--) {
            breakingDownPolishCommand(polish_command[i]);
        }
        return this.stack.pop();
    }
}
