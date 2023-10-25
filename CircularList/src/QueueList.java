import java.security.spec.RSAOtherPrimeInfo;

public class QueueList {
    Node front;
    Node rear;
    int size;
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(front == null){
            front = newNode;
            rear = newNode;
        }
        else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public void dequeue(){
        if(front == null){
            System.out.println("Queue is empty");
        }
        else{
            front = front.next;
            size--;
        }
    }
    public int sizeOfQueue(){
        Node current = front;
        int nodeCount = 0;
        while(current != null){
            nodeCount++;
            current = current.next;
        }
        return nodeCount;

    }
    public void print(){
        if(front == null){
            System.out.println("Queue is empty");
        }
        else{
            Node current = front;
            while(current != null){
                System.out.println(current.data);
                current = current.next;
            }
        }
        System.out.println("Size of Queue is: "+sizeOfQueue());
    }
    public void reverseQueue(){
        Node current = front;
        Node previous = null;
        Node next = null;
        if(front == null){
            System.out.println("Queue is Empty");
        }
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        front = previous;
        rear = current;
    }
    public int removeSecondFromFront() {
        if (front == null || front.next == null) {
            System.out.println("Queue is empty or has less than two elements.");
        }

        Node secondElement = front.next;
        front.next = secondElement.next;

        if (front.next == null) {
            rear = front;
        }

        return secondElement.data;
    }


}
