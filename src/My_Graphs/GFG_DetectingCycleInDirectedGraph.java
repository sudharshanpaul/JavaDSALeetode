package My_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GFG_DetectingCycleInDirectedGraph {

    static void main(String[] args) {

    }

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph =  new ArrayList<>();
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean ans = false;

        for(int i=0; i< V; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
        }
        for(int i=0; i< V; i++){
            if(!visited[i]){
                ans = ans || dfsDirected(i, graph, visited, pathVisited);
            }
        }
        return ans;
    }

    public boolean dfsDirected(int node, List<List<Integer>> graph, boolean[] visited, boolean[] pathVisited){
        visited[node] = true;
        pathVisited[node] = true;
        boolean ans = false;

        for(int neighbour: graph.get(node)){
            if(pathVisited[neighbour]){
                return true;
            }
            if(!visited[neighbour]){
                ans = ans || dfsDirected(neighbour, graph, visited, pathVisited);
            }
        }
        pathVisited[node] = false;
        return ans;
    }

    public boolean isCyclicBFS(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i< V; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);

            for(Integer neighbour: graph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        return ans.size() != V;

    }
}
