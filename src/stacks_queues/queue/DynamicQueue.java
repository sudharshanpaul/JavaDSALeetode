package stacks_queues.queue;

public class DynamicQueue extends CustomCircularQueue{

    public DynamicQueue(){
        super();
    }

    public DynamicQueue(int size){
        super(size);
    }

    @Override
    public boolean insert(int item) throws QueueException {
        if(this.isFull()){
            int[] temp = new int[data.length*2];

            //copy all previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front+i)%data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}
