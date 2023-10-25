public class LinkedStack {
    Node top;
    int size;
    public void push(int data){
        Node newNode = new Node(data);
        if(top == null){
            top = newNode;
        }
        else if(size == 1){
            top.next = newNode;
        }
        else{
            Node current = top;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public void pop(){
        Node current = top;
        Node previous = null;
        if(top == null){
            System.out.println("Stack is Empty");
        }
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }
    public void print(){
        Node current = top;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public void size(){
        Node current = top;
        int nodeCount = 0;
        while(current != null){
            nodeCount++;
            current = current.next;
        }
        System.out.println("Size of Stack is: "+nodeCount);
    }

}
