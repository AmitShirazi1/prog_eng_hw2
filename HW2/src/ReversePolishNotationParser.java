public class ReversePolishNotationParser extends ExpressionParser {
    //הרעיון הוא ליישם את הקייסים על פעולות החשבון בין המספרים לפי סדר מימין לשמאל
    public ReversePolishNotationParser() {
        this.is_reverse = true;
    }

    public Expression parse(String reverse_polish_notation) {
        //Stack to store operands
        this.stack = new Stack();
        String[] reverse_polish = reverse_polish_notation.split(" ");
        int expression_length = reverse_polish.length;

        //Parse the expression - left to right
        for (int i = 0; i < expression_length; i++) {
            breakingDownPolishCommand(reverse_polish[i]);
        }
        return this.stack.pop();
    }

}
//להדפיס עם סוגריים את הביטוי