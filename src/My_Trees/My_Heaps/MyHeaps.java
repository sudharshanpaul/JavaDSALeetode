package My_Trees.My_Heaps;

import java.util.ArrayList;
import java.util.List;

public class MyHeaps {
    List<Integer> heap;

    public MyHeaps(){
        heap = new ArrayList<>();
    }

    public void insert(int num){
        int pos = heap.size();
        heap.add(num);
        while(pos > 0){
            int swapPos = (pos - 1)/2;
            if(heap.get(pos) < heap.get(swapPos)){
                swap(pos, swapPos);
                pos = swapPos;
            }else{
                break;
            }
        }
    }

    public int delete(){
        int ans = heap.getFirst();
        if(heap.size() == 1){
            heap.removeLast();
            return ans;
        }
        heap.set(0, heap.removeLast());
        int pos = 0;
        while(true){
            int left = (pos + 1) * 2 - 1;
            int right = left + 1;
            if(left >= heap.size() && right >= heap.size()){
                break;
            }
            int child = getMinPos(left, right);

            if (heap.get(pos) > heap.get(child)) {
                swap(pos, child);
                pos = child;
            } else {
                break;
            }
        }

        return ans;

    }

    public List<Integer> sort(){
        List<Integer> list = new ArrayList<>();
        while(!heap.isEmpty()){
            list.add(this.delete());
        }

        return list;
    }

    private int getMinPos(int left, int right){
        if(right >= heap.size()){
            return left;
        }
        return (heap.get(left) <= heap.get(right))? left: right;
    }

    private void swap(int pos1, int pos2){
        int temp = heap.get(pos1);
        heap.set(pos1, heap.get(pos2));
        heap.set(pos2, temp);
    }
}
