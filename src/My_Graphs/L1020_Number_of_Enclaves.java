package My_Graphs;

public class L1020_Number_of_Enclaves {

    static void main(String[] args) {

    }

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        for(int i=0; i<rows; i++){
            if(grid[i][0] == 1){
                dfs(grid, i, 0);
            }

            if(grid[i][cols-1] == 1){
                dfs(grid, i, cols-1);
            }
        }


        for(int i=1; i<cols - 1; i++){
            if(grid[0][i] == 1){
                dfs(grid, 0, i);
            }

            if(grid[rows-1][i] == 1){
                dfs(grid, rows - 1, i);
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;

    }

    public void dfs(int[][] grid, int row, int col){
        grid[row][col] = 0;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};

        for(int i=0; i<4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if(isSafe(grid, nRow, nCol) && grid[nRow][nCol] == 1){
                dfs(grid, nRow, nCol);
            }
        }
    }

    public boolean isSafe(int[][] grid, int row, int col){
        return row >=0 && col >=0 && row < grid.length && col <grid[0].length;
    }
}
