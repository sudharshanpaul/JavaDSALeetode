package back_Tracking;

public class L52_NQueens2 {

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return helper(board,0);
    }

    public static int helper(boolean[][] board,int row){
        int count = 0;
        if(row == board.length){
            return 1;
        }

        for(int col=0;col<board[0].length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += helper(board,row+1);
                board[row][col] = false;
            }
        }

        return count;

    }

    public static boolean isSafe(boolean[][] board,int row,int col){
        for(int r=0;r<row;r++){
            if(board[r][col]){
                return false;
            }
        }
        int i = row-1, j = col-1;
        while(i>=0 && j>=0){
            if(board[i--][j--]){
                return false;
            }
        }
        i = row-1;
        j = col+1;
        while(i>=0 && j<board[row].length){
            if(board[i--][j++]){
                return false;
            }
        }
        return true;
    }

}
