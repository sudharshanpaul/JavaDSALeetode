package binarySearchProblems.binarySearch_2D;

public class L74_SearchA_2D_Matrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int[][] matrix2 = {{1}};
        System.out.println(searchMatrix(matrix2,0));

    }

    // https://leetcode.com/problems/search-a-2d-matrix/?envType=problem-list-v2&envId=binary-search

//    [[1,3,5,7],
//    [10,11,16,20],
//    [23,30,34,60]]

    // Approach : Find the lower bound of the target in the list of starting elements in the row
    // Then apply binary search on that row


    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix,target);
        if(row==-1){
            return false;
        }
        int start = 0;
        int end = matrix[0].length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(matrix[row][mid] == target){
                return true;
            }else if(matrix[row][mid] < target){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return false;

    }

    public static int findRow(int[][] matrix,int target){
        int start = 0;
        int end = matrix.length-1;
        while(start<=end){
           int mid = start + (end-start)/2;
           if(matrix[mid][0] == target){
               return mid;
           }else if(matrix[mid][0] < target){
               start = mid + 1;
           }else{
               end = mid - 1;
           }
        }

        return end;
    }

}
