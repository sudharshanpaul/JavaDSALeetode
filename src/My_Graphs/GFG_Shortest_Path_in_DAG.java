package My_Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class GFG_Shortest_Path_in_DAG {

    static void main(String[] args) {

    }

    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        // Code here
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i=0; i< V; i++){
            ans.add((int)(1e9));
            graph.add(new ArrayList<int[]>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // dfs(graph, ans, 0,  0);

        // return ans;
        // Queue<int[]> queue = new LinkedList<>();
        // queue.offer(new int[]{0, 0});
        // while(!queue.isEmpty()){
        //     int[] node_cost = queue.poll();
        //     int node = node_cost[0];
        //     int cost = node_cost[1];

        //     if(ans.get(node) == -1 || ans.get(node) > cost){
        //         ans.set(node, cost);
        //     }

        //     for(int[] nei: graph.get(node)){
        //         if(ans.get(nei[0]) != -1 && ans.get(nei[0]) < cost + nei[1]){
        //             continue;
        //         }
        //         queue.offer(new int[]{nei[0], cost + nei[1]});
        //     }
        // }

        // return ans;
        Stack<Integer> stack = new Stack<>();
        boolean source = true;
        for(int i=0; i<V; i++){
            if(!visited[i]){
                topoSort(stack, graph, visited, i);
            }
        }

        while(!stack.isEmpty()){
            int node = stack.pop();
            if(node != 0 && source){
                ans.set(node, -1);
                continue;
            }
            if(node == 0){
                source = false;
                ans.set(0, 0);
            }
            for(int[] nei: graph.get(node)){
                int totalCost = ans.get(node) + nei[1];
                if(totalCost < ans.get(nei[0])){
                    ans.set(nei[0], totalCost);
                }
            }
        }

        return ans;
    }

    public void dfs(ArrayList<ArrayList<int[]>> graph, ArrayList<Integer> ans, int node, int cost){
        if(ans.get(node) < 0 || ans.get(node) > cost){
            ans.set(node, cost);
        }
        // visited[node] = true;
        for(int[] nei: graph.get(node)){
            if(ans.get(nei[0]) != -1 && ans.get(nei[0]) < cost + nei[1]){
                continue;
            }
            dfs(graph, ans, nei[0], cost + nei[1]);
        }
    }

    public void topoSort(Stack<Integer> stack, ArrayList<ArrayList<int[]>> graph, boolean[] visited, int node){
        visited[node] = true;
        for(int[] nei: graph.get(node)){
            if(!visited[nei[0]]){
                topoSort(stack, graph, visited, nei[0]);
            }
        }
        stack.push(node);
    }
}
