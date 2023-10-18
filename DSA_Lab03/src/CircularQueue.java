public class CircularQueue {
    int size = 5;
    int [] Queue = new int [size];
    int front = -1;
    int back = -1;
    CircularQueue(int size){
        this.size = size;
    }
    boolean isFull(){
        if (front==back+1%size){
            return true;
        }
        else{
            return false;
        }
    }
    boolean isEmpty(){
        if(front==-1 && back==-1){
            return true;
        }
        else{
            return false;
        }
    }

    public void enqueue(int i){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(front==-1){
            front=0;
        }
        back = (back+1)%size;
        Queue[back]=i;
        System.out.println("Inserted "+i);
    }
    public void deQueue(){
        int element;
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else {
            element = Queue[front];
            if(front==back){
                front= -1;
                back = -1;
            }
            else{
                front = (front+1)%size;
            }
            System.out.println("Deleted "+element);
        }
    }
    public void display(){
        int i;
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            System.out.println("Front index: "+front);
            System.out.println("Items -> ");
            for(i=front;i!=back;i=(i+1)%size){
                System.out.println(Queue[i]+" ");
            }
            System.out.println(Queue[i]);
            System.out.println("Back index: "+back);
        }
    }

}
