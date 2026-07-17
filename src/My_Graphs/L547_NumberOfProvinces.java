package My_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class L547_NumberOfProvinces {

    static void main(String[] args) {

        int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));

    }

    public static int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i< visited.length; i++){
            if(!visited[i]){
                ans++;
                bfs(visited, isConnected, i);
            }
        }

        return ans;
    }

    public static void bfs(boolean[] visited, int[][] isConnected, int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int i=0; i<isConnected[n].length; i++){
                if(isConnected[n][i] != 0  && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }

    public static void dfs(boolean[] visited, int[][] isConnected, int node){
        visited[node] = true;

        for(int i=0; i<isConnected[node].length; i++){
            if(isConnected[node][i] != 0 && !visited[i]){
                visited[i] = true;
                dfs(visited, isConnected, i);
            }
        }
    }
}
