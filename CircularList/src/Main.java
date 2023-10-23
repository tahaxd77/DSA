public class Main {
    public static void main(String[] args) {
//        CircularList circularList = new CircularList();
//        circularList.insert(1);
//        circularList.insert(2);
//        circularList.insert(3);
//        circularList.insert(4);
//        circularList.insert(5);
//        circularList.insert(6);
//        circularList.delete(3);
//        circularList.print();
        QueueList queueList = new QueueList();
        queueList.enqueue(1);
        queueList.enqueue(2);
        queueList.enqueue(3);
        queueList.enqueue(4);
        queueList.print();
        queueList.dequeue();
        queueList.print();
        queueList.reverseQueue();
        queueList.print();
//        CircularList circularList = new CircularList();
//        circularList.insert(1);
//        circularList.insert(2);
//        circularList.insert(3);
//        circularList.insert(4);
//        circularList.print();
//        circularList.size();
//        circularList.delete(2);
//        circularList.print();
//        circularList.size();
    }
}