package My_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class L785_IsGraphBipartite {

    static void main(String[] args) {

    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        boolean ans = true;

        for(int i=0; i<graph.length; i++){
            if(color[i] == 0){
                color[i] = 1;
                ans = ans & bfsColor(i, graph, color);
            }

        }

        return ans;
    }

    public boolean bfsColor(int node, int[][] graph, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                node = queue.poll();
                int neighbourColor = giveColor(color[node]);


                for(int neighbour: graph[node]){
                    if(color[neighbour] == color[node]){
                        return false;
                    }if(color[neighbour] == 0){
                        color[neighbour] = neighbourColor;
                        queue.offer(neighbour);
                    }
                }
            }
        }

        return true;
    }

    public int giveColor(int color){
        if(color == 1){
            return 2;
        }
        return 1;
    }

    public boolean dfsColor(int node, int[][] graph, int[] color){
        int neighbourColor = 1;
        if(color[node] == 1){
            neighbourColor = 2;
        }

        boolean ans = true;

        for(int neighbour: graph[node]){
            if(color[neighbour] == color[node]){
                return false;
            }
            if(color[neighbour] == 0){
                color[neighbour] = neighbourColor;
                ans = ans & dfsColor(neighbour, graph, color);
            }
        }

        return ans;
    }
}
