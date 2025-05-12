package stacks_queues.stack;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data = new int[size];
    }

    public boolean push(int item) throws StackException {
        if(isFull()){
            throw new StackException("Stack is Full");
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Stack is Empty");
        }
        int value = data[ptr];
        ptr--;
        return value;
    }

    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Stack is Empty so we can't get the peek");
        }
        return data[ptr];
    }

    protected boolean isFull() {
        return ptr == data.length - 1;
    }

    protected boolean isEmpty(){
        return ptr == -1;
    }

}
