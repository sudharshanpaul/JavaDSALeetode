package My_Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L694_NoOfDistinctIslands {

    static void main(String[] args) {

    }

    public int countDistinctIslands(char[][] grid) {
        // code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<List<List<Integer>>> set = new HashSet<>();

        for(int i=0; i< grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    set.add(findIsland(grid, visited, i, j, i, j));
                }
            }
        }

        return set.size();

    }

    public List<List<Integer>> findIsland(char[][] grid, boolean[][] visited, int row, int col, int baseRow, int baseCol){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        visited[row][col] = true;
        list.add(row - baseRow);
        list.add(col - baseCol);
        ans.add(list);

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};

        for(int i=0; i<4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if(isSafe(grid, nRow, nCol) && !visited[nRow][nCol] && grid[nRow][nCol] == 'L'){
                ans.addAll(findIsland(grid, visited, nRow, nCol, baseRow, baseCol));
            }
        }

        return ans;
    }

    public boolean isSafe(char[][] grid, int row, int col){
        return row >=0 && col >=0 && row < grid.length && col <grid[0].length;
    }
}
