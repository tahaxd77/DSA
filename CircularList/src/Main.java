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
        queueList.removeSecondFromFront();
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
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        stack.pop();
        stack.print();
        stack.size();
    }
}