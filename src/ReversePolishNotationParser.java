public class ReversePolishNotationParser extends ExpressionParser {
//הרעיון הוא ליישם את הקייסים על פעולות החשבון בין המספרים לפי סדר מימין לשמאל
    public Expression parser(String reverse_polish_notation){
        String[] reverse_polish = reverse_polish_notation.split(" ");
        int expression_length = reverse_polish.length;
        for(int i=0; i<expression_length;i++) {
            switch (reverse_polish[i]) {
                case "+":
                    //temporary_math_expression = (double)reverse_polish[i-2]+(double)reverse_polish[i-1];
                case "-":
                    ;
                case "*":
                    ;
                case "/":
                    ;
                case "-u":
                    ;
                default:
                    // it's a number
                    if (its an int) {
                        Expression integer_operand = new IntegerLiteral(int_reverse_polish);
                    }
                    else if (its a double) {
                        Expression double_operand = new DoubleLiteral(double_reverse_polish);

                    }
            }
        }
    }

}
