public class LinkedStack {
    public Node top;
    public int size;
    public LinkedStack(){
        top = null;
        size = 0;
    }
    public boolean isEmpty(){
        if(top == null){
            return true;
        }
        else{
            return false;
        }
    }
    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else if(top.next == null){
            top = null;
        }
        else{
            Node temp = top;
            top = top.next;
            temp.next=null;
        }
    }

}
