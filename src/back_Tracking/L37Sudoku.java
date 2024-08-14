package back_Tracking;

public class L37Sudoku {
    public static void main(String[] args) {
        int[][] board = {{5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}} ;

        if(solve(board)){
            for(int[] arr:board){
                for(int digit:arr){
                    System.out.print(digit);
                }
                System.out.println();
            }
        };
    }

    public static boolean solve(int[][] board){
        int n = board.length;
        int row=-1;
        int col = -1;
        
        boolean emptyCheck = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    row = i;
                    col = j;
                    emptyCheck = false;
                }
            }
        }
        
        if(emptyCheck){
            //sudoku is solved
            return true;
        }
        
        for(int number = 1;number<=9;number++){
            if(isSafe(board,row,col,number)){
                board[row][col]=number;
                if(solve(board)){
                    return true;
                }else{
                    board[row][col]=0;
                }
            }
        }
        
        return false; //Sudoku can't be solved
    }
    
    
    static boolean isSafe(int[][] board,int row,int col,int digit){
        //Check the rows whether it is safe or not
        for(int i=0;i<board.length;i++){
            //check if the number is in the row
            if(board[i][col]==digit){
                return false;
            }
        }
        //Checking the columns
        for(int[] nums:board){
            //checking if the number is in the col
            if(nums[col]==digit){
                return false;
            }
        }
        int sqrt = (int)(Math.sqrt(board.length));
        int rowStart = row - row%sqrt;
        int colStart = col - col%sqrt;

        for(int r=rowStart;r<rowStart+sqrt;r++){
            for(int c = colStart;c<colStart+sqrt;c++){
                if(board[r][c]==digit){
                    return false;
                }
            }
        }

        return true; //It is safe
    }
}
