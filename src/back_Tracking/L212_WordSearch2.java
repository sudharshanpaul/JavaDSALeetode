package back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class L212_WordSearch2 {

    public static void main(String[] args) {

        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        char[][] board = {{'a'}};

        String[] words = {"oath","pea","eat","rain"};
//        String[] words = {"a"};
        System.out.println(findWords(board,words));



    }

    // https://leetcode.com/problems/word-search-ii/?envType=problem-list-v2&envId=backtracking
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        boolean[][] check = new boolean[board.length][board[0].length];
        for(String word:words){
            for(int i=0;i<board.length;i++){
                boolean isCheck = false;
                for(int j=0;j<board[0].length;j++){
                    if(isExist(board,check,word,0,i,j)){
                        ans.add(word);
                        isCheck = true;
                        break;
                    }
                }
                if(isCheck){
                    break;
                }
            }
        }
        return ans;
    }

    public static boolean isExist(char[][] board,boolean[][] check,String word,int digit,int row,int col){

        boolean isCheck = false;
        if(digit == word.length()){
            return true;
        }

        if(row<0 || col<0 || row==board.length || col == board[0].length){
            return false;
        }
        if(board[row][col] == word.charAt(digit) && !check[row][col]){
            check[row][col] = true;
            isCheck = isExist(board,check,word,digit+1,row-1,col) ||
                    isExist(board,check,word,digit+1,row+1,col) ||
                    isExist(board,check,word,digit+1,row,col-1) ||
                    isExist(board,check,word,digit+1,row,col+1) ;
            check[row][col] = false;
        }

        return isCheck;

    }

}
