public class Stack {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.printStack();
        stack.pop();
        stack.pop();
    }
    int[] A = new int[]{1,2,3,4,5,6,7,8,9,10};
    int top = -1;


    public void push(int element) {
        if (top == A.length - 1) {
            System.out.println("Stack is full");
        } else {
            top++;
            A[top] = element;
        }
    }

    public void pop() {
        int element = 0;
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            element = A[top];
            --top;
        }
        System.out.println(element);
    }
    public void printStack(){
        for(int i=0;i<=top;i++){
            System.out.println(A[i]);
        }
    }

}
