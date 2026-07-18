package My_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class L200_NoOfIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    ans++;
                    dfs(visited, grid, i, j);
                }
            }
        }

        return ans;
    }

    public void dfs(boolean[][] visited, char[][] grid, int row, int col){
        if(row <0 || col <0 || row>=grid.length || col>=grid[0].length || grid[row][col] == '0' || visited[row][col]){
            return;
        }
        visited[row][col] = true;
        dfs(visited, grid, row-1, col);
        dfs(visited, grid, row, col-1);
        dfs(visited, grid, row+1, col);
        dfs(visited, grid, row, col+1);

    }

    public void bfs(boolean[][] visited, char[][] grid, int row, int col){
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(row, col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            Pair element = queue.poll();
            row = element.first;
            col = element.second;

            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++){
                int nrow = row + dRow[i];
                int ncol = col + dCol[i];

                if(nrow >= 0 && ncol >= 0 &&
                        nrow < grid.length &&
                        ncol < grid[0].length &&
                        grid[nrow][ncol] == '1' &&
                        !visited[nrow][ncol]){

                    visited[nrow][ncol] = true;
                    queue.offer(new Pair(nrow, ncol));
                }
            }
        }
    }

    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
