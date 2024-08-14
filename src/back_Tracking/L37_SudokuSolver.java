package back_Tracking;

public class L37_SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}} ;

        solver1(board,0,0);
        for(char[] arr:board){
            for(char digit:arr){
                System.out.print(digit);
            }
            System.out.println();
        }
    }
//When a choice can effect future answers use backtracking
    public static void solver(char[][] board,int row,int col){
        if(row==board.length-1 && col == board[0].length){
            for(char[] arr:board){
                for(char digit:arr){
                    System.out.print(digit);
                }
                System.out.println();
            }
            return;
        }
        if(col==board[0].length){
            solver(board,row+1,0);
            return;
        }
        if(board[row][col] != '.'){
            solver(board,row,col+1);
            return;
        }else{
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,(i+"").charAt(0))){
                    board[row][col]=(i+"").charAt(0);
                    solver(board,row,col+1);
                    board[row][col]='.';

                }
            }
        }
    }
    public static boolean solver1(char[][] board,int row,int col){
        if(row==board.length-1 && col == board[0].length){
            return true;
        }
        if(col==board[0].length){
            return solver1(board,row+1,0);
        }
        if(board[row][col] != '.'){
            return solver1(board,row,col+1);
        }

            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,(i+"").charAt(0))){
                    board[row][col]=(i+"").charAt(0);
                    boolean check = solver1(board,row,col+1);
                    if(check){
                        return true;
                    }
                    board[row][col]='.';

                }
            }

        return false;
    }

    public static boolean isSafe(char[][] board,int row,int col,char digit){
        for(int i=0;i<board.length;i++){
            if(board[i][col]==digit || board[row][i]==digit){
                return false;
            }
        }
        int r = (row/3)*3;
        int c = (col/3)*3;

        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
}
