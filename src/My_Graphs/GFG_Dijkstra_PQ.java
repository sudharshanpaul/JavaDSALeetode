package My_Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GFG_Dijkstra_PQ {

    static void main(String[] args) {

    }

    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<Integer> minDistances = new ArrayList<>();
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i< V; i++){
            graph.add(new ArrayList<int[]>());
            minDistances.add((int)1e9);
        }

        for(int[] edge: edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[]{src, 0});
        minDistances.set(src, 0);

        while(!queue.isEmpty()){
            int[] node_cost = queue.poll();
            int node = node_cost[0];
            int cost = node_cost[1];

            if(cost > minDistances.get(node)){
                continue;
            }

            for(int[] nei_cost: graph.get(node)){
                int newCost = cost + nei_cost[1];
                int nei = nei_cost[0];

                if(minDistances.get(nei) > newCost){
                    minDistances.set(nei, newCost);
                    queue.offer(new int[]{nei, newCost});
                }
            }
        }

        return minDistances;
    }
}
