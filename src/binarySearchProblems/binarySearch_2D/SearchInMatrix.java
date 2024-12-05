package binarySearchProblems.binarySearch_2D;


import java.util.ArrayList;
import java.util.Arrays;


public class SearchInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {18,9,12},
                {36,-4,91},
                {44,33,16}
        };
        //System.out.println(Arrays.toString(linearSearch2D(matrix,91)));
        int[][] matrix2 = {
                {10,20,30,40},
                {12,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        System.out.println(Arrays.toString(searchInSorted2D(matrix2,40)));
    }

    // Time complexity of linear Search in 2D Array is O(n^2)
    public static int[] linearSearch2D(int[][] matrix,int target){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    // If we are given a sorted array which is sorted in both column and row wise
    //here the worst time complexity is O(r+c) i.e O(2n) i.e O(n)
    public static int[] searchInSorted2D(int[][] array, int target){
        int start = 0;
        int end = array[0].length-1;
        while(start< array.length && end >=0){
            if(array[start][end]==target)
                return new int[]{start,end};
            else if (array[start][end]>target)
                end--;
            else
                start++;
        }
        return null;
    }
}
