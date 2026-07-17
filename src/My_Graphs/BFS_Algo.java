package My_Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Algo {

    static void main(String[] args) {

    }

    public List<Integer> BFS(int n, HashMap<Integer, List<Integer>> graph){
        int[] initArray = new int[n+1];
        initArray[1] = 1;
        List<Integer> ans = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);

            for(Integer element: graph.get(node)){
                if(initArray[element] == 0){
                    initArray[element] = 1; // Making as visited
                    queue.offer(element);
                }
            }
        }

        return ans;
    }
}
