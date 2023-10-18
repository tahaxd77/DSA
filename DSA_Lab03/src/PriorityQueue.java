import java.util.Arrays;

public class PriorityQueue {
     int[] array;
    int size;


     PriorityQueue(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public void enqueue(int element) {
         int i=0;
        if (isFull()) {
            if(size == 0){
                array[size++] = element;
            }
        }else {
            for (i = size - 1; i>=0; i--){
                if(element>array[i]){
                    array[i+1] = array[i];
                }
                else {
                    break;
                }
            }
        }
        array[i+1] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty. Cannot dequeue.");
            return -1; // Or throw an exception
        }
        return array[--size];
    }


    public void display() {
        if (isEmpty()) {
            System.out.println("Priority queue is empty.");
            return;
        }

        System.out.print("Priority queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(10);

        priorityQueue.enqueue(3);
        priorityQueue.enqueue(5);
        priorityQueue.enqueue(1);
        priorityQueue.enqueue(7);
        priorityQueue.enqueue(2);

        priorityQueue.display(); // Output: Priority queue elements: 7 5 1 3 2

        System.out.println("Dequeue: " + priorityQueue.dequeue()); // Output: Dequeue: 7

        priorityQueue.display(); // Output: Priority queue elements: 5 3 1 2
        priorityQueue.dequeue();
        priorityQueue.display();
        
    }
}
