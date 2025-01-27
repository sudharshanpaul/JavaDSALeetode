package arrayProblems.arrays2D;

import java.util.Arrays;

public class L566_Reshape_the_Matrix {

    public static void main(String[] args) {

        int[][] mat = {{1,2},{3,4}};
        int[][] ans = matrixReshape(mat,1,4);
        for(int[] arr: ans){
            System.out.println(Arrays.toString(arr));
        }

    }

    // https://leetcode.com/problems/reshape-the-matrix/?envType=problem-list-v2&envId=matrix
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length*mat[0].length){
            return mat;
        }
        int[][] ans = new int[r][c];
        int row = 0;
        int col = 0;

        for(int[] arr:mat){
            for(int value: arr){
                ans[row][col] = value;
                col++;
                if(col==c){
                    col = 0;
                    row++;
                }
            }
        }

        return ans;

    }

}
