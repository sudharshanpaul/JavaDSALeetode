package My_Graphs;

import java.util.*;

public class GFG_ShortestPath_UnweightedGraph {

    static void main(String[] args) {

    }

    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] ans = new int[V];

        for(int i=0; i<V; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Arrays.fill(ans, (int) 1e9);

        queue.offer(new int[]{src, 0});
        ans[src] = 0;
        int parent = -1;

        while(!queue.isEmpty()){
            int[] node_cost = queue.poll();

            int node = node_cost[0];
            int cost = node_cost[1];

            if(node == dest){
                return cost;
            }

            for(int nei: graph.get(node)){
                if(nei != parent && ans[nei] > cost + 1){
                    ans[nei] = cost+1;
                    queue.offer(new int[]{nei, cost + 1});
                }
            }
            parent = node;
        }

        return -1;


    }
}
