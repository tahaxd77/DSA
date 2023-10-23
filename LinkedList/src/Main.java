public class Main {
    public static void main(String[] args) {
       LinkedList list = new LinkedList();
       LinkedList list1 = new LinkedList();
       list1.insertAtStart(11);
       list1.insertAtEnd(22);
       list1.insertAtEnd(33);
       list1.insertAtEnd(44);
       LinkedList list2 = new LinkedList();
       list2.insertAtStart(55);
       list2.insertAtEnd(66);
       list2.insertAtEnd(77);
       list2.insertAtEnd(88);
       list2.insertAtEnd(99);

       System.out.println("List after concatenation: ");
       list.listConcat(list1, list2);
       System.out.println("List 1: ");
       list1.printList();
       System.out.println("List 2: ");
       list2.printList();
       list.replaceAtPosition(list1, 2,99);
       System.out.println("List after replacing: ");
       list1.printList();
       System.out.println(list2.findSecondToLast());
       list2.rotateAtIndex(2);
         System.out.println("List after rotation: ");
         list2.printList();
         list2.reverseList();
            System.out.println("List after reversing: ");
         list2.printList();
    }
}