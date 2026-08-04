package My_Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class topologicalSort {

    static void main(String[] args) {
        int[][] graph = {{},{},{3},{1},{0,1},{0,2}};
        System.out.println(topologicalSort(graph));
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


}
