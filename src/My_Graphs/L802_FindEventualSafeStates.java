package My_Graphs;

import java.util.ArrayList;
import java.util.List;

public class L802_FindEventualSafeStates {

    static void main(String[] args) {

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] pathVisited = new boolean[graph.length];
        boolean[] check = new boolean[graph.length];
        List<Integer> ans = new ArrayList<>();


        for(int i=0; i< graph.length; i++){
            if(!visited[i]){
                if(!dfs(i, graph, visited, pathVisited, check)){
                    ans.add(i);
                }
            }else if(!check[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] pathVisited,
                       boolean[] check){

        visited[node] = true;
        pathVisited[node] = true;
        check[node] = true;

        for(int neighbour: graph[node]){
            if(pathVisited[neighbour] || check[neighbour]){
                return true;
            }
            if(!visited[neighbour] && dfs(neighbour, graph, visited, pathVisited, check)){
                return true;
            }
        }

        pathVisited[node] = false;
        check[node] = false;

        return false;
    }
}
