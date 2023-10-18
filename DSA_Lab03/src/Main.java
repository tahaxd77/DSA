import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the size of the queue :");
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int size = sc.nextInt();
        CircularQueue cq = new CircularQueue(size);
        int choice = 0;
        while (choice != 4) {
            System.out.println("Enter your choice :");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            choice = sc2.nextInt();
                if(choice == 1) {
                    int element = 0;
                    while (element != -1) {
                        System.out.println("Enter the element to be inserted (-1 to exit) :");
                        element = sc.nextInt();
                        if(element== -1) {
                            break;
                        }else {
                            cq.enqueue(element);
                        }
                    }
                }
                else if(choice == 2) {
                    cq.deQueue();
                    break;
                }
                else if (choice ==3) {
                    cq.display();
                    break;
                }
                else if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                }
                else {
                    System.out.println("Invalid choice");
                }
        }
    }
}
