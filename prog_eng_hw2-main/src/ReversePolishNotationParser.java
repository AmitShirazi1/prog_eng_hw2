public class ReversePolishNotationParser extends ExpressionParser {
    //הרעיון הוא ליישם את הקייסים על פעולות החשבון בין המספרים לפי סדר מימין לשמאל
    public Expression parse(String reverse_polish_notation) {

        //Stack to store operands
        Stack<Expression> stack = new Stack<Expression>();
        String[] reverse_polish = reverse_polish_notation.split(" ");
        int expression_length = reverse_polish.length;

        Expression operand1;
        Expression operand2;
        Expression result;
        double operand_double;
        int operand_int;

        //Parse the expression
        for (int i = 0; i < expression_length; i++) {
            switch (reverse_polish[i]) {
                case "+":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    result = new Addition(operand1, operand2);
                    stack.push(result);
                    break;
                case "-":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    result = new Subtraction(operand1, operand2);
                    stack.push(result);
                    break;
                case "*":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    result = new Multiplication(operand1, operand2);
                    stack.push(result);
                    break;
                case "/":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    result = new Division(operand1, operand2);
                    stack.push(result);
                    break;
                case "-u":
                    operand1 = stack.pop();
                    result = new UnaryMinus(operand1);
                    stack.push(result);
                default:
                    // it's a number
                    if (reverse_polish[i].contains(".")) {
                        operand_double = Double.parseDouble(reverse_polish[i]);
                        result = new DoubleLiteral(operand_double);
                        stack.push(result);
                    } else {
                        operand_int = Integer.parseInt(reverse_polish[i]);
                        result = new IntegerLiteral(operand_int);
                        stack.push(result);
                    }
            }
        }
        return stack.pop();
    }

}
//להדפיס עם סוגריים את הביטוי