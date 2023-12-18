package Queue;

public class Queue {
    private int front;
    private int rear;
    private int[] arrayQueue;
    private final int size;


    Queue(int size){
        this.size = size;
        this.arrayQueue = new int[size];
    }

    Queue(){
        this(5);
    }

    public void enqueue(int value){
        if (isFull()){
            resizeArray();
        }
        arrayQueue[rear] = value;
        rear++;
    }

    private void resizeArray(){
        int[] temp = arrayQueue;
        arrayQueue = new int[size*2];
        for (int i = 0; i < temp.length; i++) {
            arrayQueue[i] = temp[i];
        }
    }


    public int dequeue(){
        if(!isEmpty() && !(front > rear)){
            front++;
            return arrayQueue[front-1];
        }
        throw new IllegalArgumentException();
    }


    public int peek(){
        if(!isEmpty() && !(front > rear)){
            return arrayQueue[front];
        }
        throw new IllegalArgumentException();
    }


    private boolean isFull(){
        return rear == size;
    }


    private boolean isEmpty(){
        return rear == 0;
    }


    public void printQueue(){
        if (!isEmpty()){
            for (int i = front; i < rear; i++) {
                if (i < rear-1){
                    System.out.print(arrayQueue[i]+", ");
                } else {
                    System.out.println(arrayQueue[i]);
                }
            }
        }
    }
}
