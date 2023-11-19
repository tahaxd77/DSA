import java.util.Arrays;

public class PriorityQueue {
     int[] array;
    int size;
    int front=-1;
    int rear=-1;



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

    public void enqueue (int element) {
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
    public void Enqueue(int element){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(front==-1){
            front=0;
        }
        rear=(rear+1)%array.length;
        array[rear]=element;
        size++;
    }
    public void Dequeue(){
         int element;
         if(isEmpty()){
             System.out.println("Queue is empty");
         }
         else{
             int index = FindMinIndex();
             for (int k = index; k < size - 1; k++) {
                 array[k] = array[k + 1];
             }
                size--;
         }
    }
    public int FindMinIndex(){
         int min = 0;
            for(int i=0;i<size;i++){
                if(array[i]<array[min]){
                    min = i;
                }
            }
            return min;
    }
    public int FindMaxIndex(){
        int max = 0;
        for(int i=0;i<size;i++){
            if(array[i]>array[max]){
                max = i;
            }
        }
        return max;
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

       priorityQueue.Enqueue(5);
         priorityQueue.Enqueue(3);
            priorityQueue.Enqueue(1);
                priorityQueue.Enqueue(2);
                    priorityQueue.Enqueue(7);

        priorityQueue.display();// Output: Priority queue elements: 7 5 1 3 2
        priorityQueue.Dequeue();
        priorityQueue.display();

//        System.out.println("Dequeue: " + priorityQueue.dequeue()); // Output: Dequeue: 7
//
//        priorityQueue.display(); // Output: Priority queue elements: 5 3 1 2
//        priorityQueue.dequeue();
//        priorityQueue.display();
        
    }
}
