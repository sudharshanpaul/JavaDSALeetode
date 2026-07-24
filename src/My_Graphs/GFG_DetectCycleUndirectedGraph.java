package My_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GFG_DetectCycleUndirectedGraph {

    static void main(String[] args) {

    }

    public boolean isCycle(int V, int[][] edges) {
        // Code here
        boolean ans = false;
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i<V; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<edges.length; i++){
            int first = edges[i][0];
            int second = edges[i][1];
            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        for(int i=0; i<V; i++){
            if(!visited[i]){
                ans = ans || dfs(visited, graph, i, -1);
            }
        }

        return ans;

    }

    public boolean bfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph, int node){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, -1});
        visited[node] = true;

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            node = pair[0];
            int parent = pair[1];

            for(Integer neighbour: graph.get(node)){
                if(neighbour == parent){
                    continue;
                }
                if(visited[neighbour]){
                    return true;
                }
                queue.offer(new int[]{neighbour, node});
                visited[neighbour] = true;
            }
        }

        return false;


    }

    public boolean dfs(boolean[] visited, ArrayList<ArrayList<Integer>> graph, int node, int parent){
        visited[node] = true;
        boolean ans = false;

        for(Integer neighbour: graph.get(node)){
            if(neighbour == parent){
                continue;
            }
            if(visited[neighbour]){
                return true;
            }
            ans = ans || dfs(visited, graph, neighbour, node);
        }

        return ans;
    }
}
