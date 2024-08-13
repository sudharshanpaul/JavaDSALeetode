package back_Tracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class L51_NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
//        for(boolean[] arr:board){
//            System.out.println(Arrays.toString(arr));
//        }
//        System.out.println();
//        solver(board,0);
        List<List<String>> list = solver1(board,0);
        for(List<String> i:list){
            System.out.println(i);
        }
        System.out.println(queens(board,0));


    }

    //// https://leetcode.com/problems/n-queens/description/
    public static int queens(boolean[][] board,int row){
        int count = 0;
        if(row==board.length){
            display(board);
            return 1;
        }

        for(int col=0;col<board[0].length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count+=queens(board,row+1);
                board[row][col] = false;
            }
        }

        return count;
    }
    public static void display(boolean[][] board){
        for(boolean[] row:board){
            for(boolean element:row){
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isSafe(boolean[][] board,int row,int col){
        //Checking vertically
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        //Checking diagonally left
        int maxLeft = Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }
        int maxRight = Math.min(row,board[0].length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    public static void solver(boolean[][] board,int row){
        if(row==board.length){
            for(boolean[] arr: board){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }

        for(int col=0;col<board[0].length;col++){
            int j=row;
            int k = col;
            int l = col;
            boolean check = false;
            while(j>=0){
                if(board[j][col]){
                    check = true;
                    break;
                }
                j--;

            }
            j=row;
            while(j>=0 && k>=0){
                if(board[j][k]){
                    check = true;
                    break;
                }
                j--;
                k--;
            }
            j=row;
            while(j>=0 && l<board[0].length){
                if(board[j][l]){
                    check = true;
                    break;
                }
                j--;
                l++;
            }
            if(!check){
                board[row][col] = true;
                solver(board,row+1);
                board[row][col] = false;
            }

        }

    }


    // https://leetcode.com/problems/n-queens/description/
    //Solution 1
    public static List<List<String>> solver1(boolean[][] board,int row){
        List<List<String>> list = new ArrayList<>();
        List<String> inner = new ArrayList<>();

        if(row==board.length){

            for(int i=0;i<board.length;i++){
                String p = "";

                for(int j=0;j<board[0].length;j++){
                    if(board[i][j]){
                        p=p+"Q";
                    }else{
                        p = p+'.';
                    }
                }
                inner.add(p);
            }
            list.add(inner);
            System.out.println();
            return list;
        }

        for(int col=0;col<board[0].length;col++){
            int j=row;
            int k = col;
            int l = col;
            boolean check = false;
            //Place the queen if it safe
            while(j>=0){
                if(board[j][col]){
                    check = true;
                    break;
                }
                j--;

            }
            j=row;
            while(j>=0 && k>=0){
                if(board[j][k]){
                    check = true;
                    break;
                }
                j--;
                k--;
            }
            j=row;
            while(j>=0 && l<board[0].length){
                if(board[j][l]){
                    check = true;
                    break;
                }
                j--;
                l++;
            }
            if(!check){
                board[row][col] = true;
                list.addAll(solver1(board,row+1));
                board[row][col] = false;
            }


        }

        return list;
    }



}
