public class Main {
    public static void main(String[] args) {
        Node node = new Node();
//        d = new Node(4,null);
//        c = new Node(3,d);
//        b = new Node(2,c);
//        a = new Node(1,b);

        node.insertAtStart(3);
        node.insertAtEnd(2);
        node.insertAtEnd(3);
        node.insertAtEnd(2);
        node.insertAtEnd(3);
        node.insertAtEnd(2);
        node.insertAtEnd(4);
        //node.sotData();
        node.removeRepeating();
        node.printList();

    }
}