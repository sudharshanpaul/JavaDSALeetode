package My_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS_Algo {

    static void main(String[] args) {

    }

    static List<Integer> ans;

    public static List<Integer> dfs(int V, List<List<Integer>> graph){
        boolean[] visited = new boolean[V];
        ans = new ArrayList<>();

        helper(visited, graph, 0);

        return ans;

    }

    public static void helper(boolean[] visited, List<List<Integer>> graph, int node){
        ans.add(node);
        visited[node] = true;
        for(Integer n:graph.get(node)){
            if(!visited[n]){
                helper(visited, graph, n);
            }
        }
    }
}
