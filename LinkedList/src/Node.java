public class Node {
    public int data;
    public Node next;
    public Node head;
    public Node() {
        this.head = null;
    }
    public Node(int data) {
        this.data = data;

    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public void insertAtEnd(int data){
        Node newNode = new Node(data);
        Node current = head;
        if(head == null){
            head = newNode;
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void insertAtStart(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
            System.out.println("New head is: " + head.data);
        }
    }
public void insertAtPosition(int data, int position){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else if(position == 0){
            newNode.next = head;
            head = newNode;
        }
        else{
            Node current = head;
            Node previous = null;
            int nodeCount = 0;
            while (current!=null){
                nodeCount = nodeCount + 1;
                if(nodeCount == position){
                    newNode.next = current;
                    previous.next = newNode;
                    break;
                }
                previous = current;
                current = current.next;
            }
        }
    }
    public void deleteAtPosition(int position){
        if(head == null){
            System.out.println("List is empty");
        }
        else if(position == 0){
            head = head.next;
        }
        else{
            Node current = head;
            Node previous = null;
            int nodeCount = 0;
            while (current!=null){
                nodeCount = nodeCount + 1;
                if(nodeCount == position){
                    previous.next = current.next;
                    break;
                }
                previous = current;
                current = current.next;
            }
        }
    }
    public void sotData(){
        Node current = head;
        Node temp;
        int tempData;
        while(current != null){
            temp = current.next;
            while (temp != null) {
                try {
                    if (current.data > temp.data) {
                        tempData = current.data;
                        current.data = temp.data;
                        temp.data = tempData;
                        temp = temp.next;
                    } else if (current.data <= temp.data) {
                        temp = temp.next;
                    }
                } catch (NullPointerException e) {
                    break;
                }
            }
            current = current.next;
        }
    }
    public void reverseList(){
        Node current = head;
        Node previous = null;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    public void removeRepeating(){
        Node current = head;
        Node previous = head;
        Node temp = null;
        Node next = current.next;
        while (current.next!=null){
            while(next.next!=null){
                if(current.data == next.data){
                    temp = next;
                    previous.next = next.next;
                    next = next.next;
                    temp.next = null;
                }
                else{
                    next = next.next;
                    previous = previous.next;
                }
            }
            current = current.next;
            previous = current;
            next = current.next;

        }
    }
}
