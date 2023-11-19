import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String infix = "((a + b) * c – (d – e))/(f + g)";
        String prefix = "*-a/bc-/ade";
        String postfix = "abc/-ad/e-*";
        System.out.println("Infix Expression: " + infix);
        System.out.println("Postfix Expression: " + infixToPostfix(infix));
        //System.out.println(postfixEvaluation(postfix));
        System.out.println("Prefix Expression: " + prefix);
        System.out.println("Postfix Expression: " + prefixToPostfix(prefix));
        System.out.println("Postfix Expression: " + postfix);
        System.out.println("Prefix Expression: " + postfixToPrefix(postfix));
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
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else if (ch == ' ') {
                continue;
            } else {
                if (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }else if(!stack.isEmpty() && precedence(ch) > precedence(stack.peek())) {
                    stack.push(ch);
                }
//                }else {
//                    stack.push(ch);
//                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                stack.pop();
            }
            else{
                postfix.append(stack.pop());
            }

        }
        return postfix.toString();
    }
    public static String prefixToPostfix(String prefix){
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        int length = prefix.length();
        for(int i = length - 1; i >= 0; i--){
            char ch = prefix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
               stack.push(String.valueOf(ch));
            }
            else if(ch == ' '){
                continue;
            }
            else if (isOperator(ch)){

                    String operand1 = String.valueOf(stack.pop());
                    String operand2 = String.valueOf(stack.pop());
                    String result = operand1 + operand2 + ch;
                    stack.push(result);

            }
        }
        return stack.pop();
    }
    public static String postfixToPrefix(String postfix){
        Stack<String> stack = new Stack<>();
        //StringBuilder prefix = new StringBuilder();
        int length = postfix.length();
        for(int i = 0; i <= length-1; i++){
            char ch = postfix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(String.valueOf(ch));
            }
            else if(ch == ' '){
                continue;
            }
            else if (isOperator(ch)){

                String operand1 = String.valueOf(stack.pop());
                String operand2 = String.valueOf(stack.pop());
                String result =ch + operand2 + operand1;
                stack.push(result);

            }
        }
        return stack.pop();
    }
    public static boolean isOperator(char ch){
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
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
            case '(':
                return 0;
        }
        return -1;
    }
}

