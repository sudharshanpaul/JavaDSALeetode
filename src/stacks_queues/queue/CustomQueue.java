package stacks_queues.queue;

public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;


    public  CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        data = new int[size];
    }

    public boolean insert(int item) throws QueueException{
        if(isFull()){
            throw new QueueException("Queue is full");
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty");
        }
        int removed = data[0];

        // Shift the items
        for (int i = 1; i < end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty");
        }
        return data[0];
    }

    public void display(){
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }

    protected boolean isFull(){
        return end == data.length ;
    }

    protected boolean isEmpty() {
        return end == 0;
    }
}
