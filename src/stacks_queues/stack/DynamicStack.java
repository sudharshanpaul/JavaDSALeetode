package stacks_queues.stack;

public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super();
    }
    public DynamicStack(int size){
        super(size);
    }

    @Override
    public boolean push(int item) throws StackException {
        // this takes care of being full
        if(this.isFull()){
            int[] temp = new int[data.length*2];

            //copy all the items in the new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }
        // at this position we that array is nor full
        // insert the item
        return super.push(item);
    }
}
