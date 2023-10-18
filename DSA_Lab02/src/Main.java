import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String infix = "a - b / ( c + d * e )";
        //String postfix = "2345-56/*+*+";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + infixToPostfix(infix));
        //System.out.println(postfixEvaluation(postfix));
    }
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                else if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else if (ch == ' ') {
                continue;
            } else {
                if (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        if (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                postfix.append(stack.pop());
            }
            else{
                postfix.append(stack.pop());
            }

        }
        return postfix.toString();
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}

