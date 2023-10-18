import java.util.Stack;
public class Stack2 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(20);
        System.out.println(stack);
        int topElement = stack.peek();
        System.out.println(topElement);
        stack.pop();
        stack.pop();
        System.out.println(stack);

    }

}
