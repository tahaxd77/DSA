import java.util.Stack;

public class postfixEvaluation {
    public static Stack postfixEvaluation(String postfix) {
        try {
            Stack<Integer> stack = new Stack<>();
            for (char ch : postfix.toCharArray()) {
                if (Character.isDigit(ch)) {
                    stack.push(ch - '0');
                    System.out.println(stack);
                } else {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    switch (ch) {
                        case '+':
                            stack.push(val2 + val1);
                            System.out.println(stack);
                            break;
                        case '-':
                            stack.push(val2 - val1);
                            System.out.println(stack);
                            break;
                        case '*':
                            stack.push(val2 * val1);
                            System.out.println(stack);
                            break;
                        case '/':
                            if(val1 == 0){
                                System.out.println("Cannot divide by zero");
                                return null;
                            }
                            else{
                                stack.push(val2 / val1);
                                System.out.println(stack);
                                break;
                            }
                        case '^':
                            stack.push((int) Math.pow(val2, val1));
                            System.out.println(stack);
                            break;
                        default:
                            System.out.println("Invalid Operator");
                    }

                }
                if (stack.size() != 1 && stack.isEmpty()) {
                    System.out.println("Stack is empty");
                }
            }
            return stack;
        } catch (Exception e) {
            System.out.println("Invalid Expression");
        }
        return null;
    }

    public static void main(String[] args) {
        String postfix = "12+3*6+23+/";
        System.out.println(postfixEvaluation(postfix));
    }
}
