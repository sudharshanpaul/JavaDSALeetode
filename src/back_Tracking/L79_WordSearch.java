package back_Tracking;

public class L79_WordSearch {

    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,"SEE"));

    }

    // https://leetcode.com/problems/word-search/?envType=problem-list-v2&envId=backtracking
    public static boolean exist(char[][] board, String word) {

        boolean[][] check = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,check,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean helper(char[][] board,boolean[][] check,String word,int digit,int row,int col){
        boolean isCheck = false;
        if(digit==word.length()){
            return true;
        }
        if(row<0 || col<0 || row==board.length || col == board[0].length){
            return false;
        }
        if(board[row][col] == word.charAt(digit) && !check[row][col]){
            check[row][col] = true;
            isCheck = helper(board,check,word,digit+1,row-1,col) ||
                    helper(board,check,word,digit+1,row+1,col) ||
                    helper(board,check,word,digit+1,row,col-1) ||
                    helper(board,check,word,digit+1,row,col+1) ;
            check[row][col] = false;
        }


        return isCheck;
    }

}
