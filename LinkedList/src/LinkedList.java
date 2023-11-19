public class LinkedList {
    public Node head;

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node current = head;
        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
            System.out.println("New head is: " + head.data);
        }
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            Node previous = null;
            int nodeCount = 0;
            while (current != null) {
                nodeCount = nodeCount + 1;
                if (nodeCount == position) {
                    newNode.next = current;
                    previous.next = newNode;
                    break;
                }
                previous = current;
                current = current.next;
            }
        }
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
        } else if (position == 0) {
            head = head.next;
        } else {
            Node current = head;
            Node previous = null;
            int nodeCount = 0;
            while (current != null) {
                nodeCount = nodeCount + 1;
                if (nodeCount == position) {
                    previous.next = current.next;
                    break;
                }
                previous = current;
                current = current.next;
            }
        }
    }

    public void sotData() {
        Node current = head;
        Node temp;
        int tempData;
        while (current != null) {
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

    public void reverseList() {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    public void sortedInsert(int data){
        Node newNode = new Node(data);
        if(head == null || head.data >= newNode.data){
            newNode.next = head;
            head = newNode;
        }
        else{
            Node current = head;
            Node previous = null;
            while(current.next != null && current.next.data < newNode.data){
                current = current.next;
            }
            newNode.next = current;
            current.next = newNode;
        }
    }

    public void removeRepeating() {
        Node current = head;
        Node previous = head;
        Node temp = null;
        Node next = current.next;
        while (current.next != null) {
            while (next.next != null) {
                if (current.data == next.data) {
                    temp = next;
                    previous.next = next.next;
                    next = next.next;
                    temp.next = null;
                } else {
                    next = next.next;
                    previous = previous.next;
                }
            }
            current = current.next;
            previous = current;
            next = current.next;

        }
    }
    public LinkedList copyList(){
        LinkedList newList = new LinkedList();
        Node current = head;
        while(current != null){
            newList.insertAtEnd(current.data);
            current = current.next;
        }
       return newList;

    }
    public void listConcat(LinkedList list1, LinkedList list2 ){
        LinkedList tempList1 = list1.copyList();
        LinkedList tempList2 = list2.copyList();
        LinkedList newList = new LinkedList();
        Node current = tempList1.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = tempList2.head;
        newList = tempList1;
         newList.printList();
    }
    public void replaceAtPosition(LinkedList list1 ,int location ,int data){
        Node current = list1.head;
        int nodeCount = 0;
        while(current != null){
            nodeCount = nodeCount + 1;
            if(nodeCount == location){
                current.data = data;
                break;
            }
            current = current.next;
        }
    }
    public Node findSecondToLast(){
        Node current = head;
        Node previous = null;
        if(head== null){
            return null;
        }
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        return previous;
    }
    public void rotateAtIndex(int index){
        Node current = head;
        Node previous = null;
        Node temp = null;
        int nodeCount = 0;
        while(current.next != null) {
            nodeCount = nodeCount + 1;
            if (nodeCount == index) {
                temp = current;
                previous.next = null;
                break;
            }
            previous = current;
            current = current.next;
        }

            Node temp1 = current;
            while(temp1.next != null){
                temp1 = temp1.next;
            }
            temp1.next = head;
            head = temp;
        }
    }
