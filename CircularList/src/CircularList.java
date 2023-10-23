public class CircularList {
    Node head;
    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            newNode.next = head;
        }
        else{
            Node current = head;
            while(current.next != head){
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }
    public void delete(int position){
        if(head == null){
            System.out.println("List is empty");
        }
        else if(position == 0){
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = head.next;
            head = head.next;
        }
        else{
            Node current = head;
            Node previous = null;
            int nodeCount = 0;
while (current.next != head){
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
    public void print(){
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            Node current = head;
            while(current.next != head){
                System.out.println(current.data);
                current = current.next;
            }
            System.out.println(current.data);
        }
    }
    public void size(){
        Node current = head;
        int nodeCount = 0;
        if(head == null){
            System.out.println("List is empty");
        }
        while(current.next != head){
            nodeCount = nodeCount + 1;
            current = current.next;
        }
        System.out.println("Size of list is: " + (nodeCount + 1));
    }
}
