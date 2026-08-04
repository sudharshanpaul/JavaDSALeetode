package My_Graphs;

import java.util.*;

public class topologicalSort {

    static void main(String[] args) {
        int[][] graph = {{},{},{3},{1},{0,1},{0,2}};
        System.out.println(topologicalSort(graph));
        System.out.println(topoSort2(graph));
    }

    public static List<Integer> topologicalSort(int[][] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                dfs(i, stack, graph, visited);
            }
        }

        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }

        return ans;

    }

    public static void dfs(int node, Stack<Integer> stack, int[][] graph, boolean[] visited){
        visited[node] = true;

        for(int neighbour: graph[node]){
            if(!visited[neighbour]){
                dfs(neighbour, stack, graph, visited);
            }
        }

        stack.push(node);
    }

    public static List<Integer> topoSort2(int[][] graph){
        int[] indegree = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<graph.length; i++){
            for(Integer nei: graph[i]){
                indegree[nei]++;
            }
        }

        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int neighbour: graph[node]) {
                if (--indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return ans;
    }


}
