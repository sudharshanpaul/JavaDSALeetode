package stacks_queues.queue;

public class CustomCircularQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    protected int front = 0;
    protected int end = 0;
    protected int size = 0;

    public CustomCircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomCircularQueue(int size){
        data = new int[size];
    }

    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean insert(int item) throws QueueException{
        if(isFull()){
            throw new QueueException("Circular Queue is Full");
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Circular Queue is Empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Circular Queue is Empty");
        }
        return data[front];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Circular Queue is Empty");
        }
        int i = front;
        do{
            System.out.print(data[i] + "->");
            i++;
            i %= data.length;
        }while(i!=end);
        System.out.println("END");
    }

}
