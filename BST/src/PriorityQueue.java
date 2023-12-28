class PriorityQueue {
    Node head;

    PriorityQueue() {
        head = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null || data < head.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && data >= current.next.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    int remove() {
        if (head == null) {
            System.out.println("Priority queue is empty");
        }
        int removedData = head.data;
        head = head.next;
        return removedData;
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        pq.insert(5);
        pq.insert(3);
        pq.insert(8);
        pq.insert(1);
        pq.insert(6);

        System.out.println("Priority Queue elements:");
        pq.display();

        System.out.println("Removing highest priority element:");
        int removed = pq.remove();
        if (removed != Integer.MIN_VALUE) {
            System.out.println("Removed element: " + removed);
        }

        System.out.println("Priority Queue elements after removal:");
        pq.display();
    }
}

