package My_Graphs;

public class L130_SurroundedNeighbours {

    static void main(String[] args) {

    }

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int rows = board.length;
        int cols = board[0].length;

        // First and last column
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                visited[i][0] = true;
                dfs(board, visited, i, 0);
            }

            if (board[i][cols - 1] == 'O' && !visited[i][cols - 1]) {
                visited[i][cols - 1] = true;
                dfs(board, visited, i, cols - 1);
            }
        }

        // First and last row (excluding corners to avoid duplicates)
        for (int j = 1; j < cols - 1; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                visited[0][j] = true;
                dfs(board, visited, 0, j);
            }

            if (board[rows - 1][j] == 'O' && !visited[rows - 1][j]) {
                visited[rows - 1][j] = true;
                dfs(board, visited, rows - 1, j);
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, boolean[][]  visited, int row, int col){
        visited[row][col] = true;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, -1, 0, 1};

        for(int i=0; i<4; i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            if(isSafe(nRow, nCol, board) && !visited[nRow][nCol] && board[nRow][nCol] == 'O'){
                dfs(board, visited,nRow, nCol);
            }
        }
    }

    public boolean isSafe(int row, int col, char[][] board){
        return row >=0 && col >=0 && row < board.length && col < board[0].length;
    }
}
