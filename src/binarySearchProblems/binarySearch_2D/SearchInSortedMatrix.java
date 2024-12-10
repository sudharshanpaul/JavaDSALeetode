package binarySearchProblems.binarySearch_2D;

import java.util.Arrays;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,13},
                {14,15,15,16}
        };
//        System.out.println(Arrays.toString(find(matrix,12)));
        System.out.println(Arrays.toString(search(matrix,7)));
    }

    public static int[] find(int[][] matrix,int target){
        int row = findRow(matrix,target);
        int start = 0;
        int end = matrix[0].length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[row][mid]==target){
                return new int[]{row,mid};
            }else if(matrix[row][mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    //Here we are finding the row in which the target may exist...
    public static int findRow(int[][] matrix,int target){
        int start = 0;
        int end = matrix.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[mid][0]==target){
                return mid;
            } else if (matrix[mid][0]<target) {
                start = mid+1;
            }else{
                end = mid - 1;
            }
        }

        return end;
    }
    // 2nd Approach
    public static int[] binarySearch(int[][] matrix,int row,int cstart,int cend,int target){
        while(cstart<=cend){
            int mid = cstart + (cend-cstart)/2;
            if(matrix[row][mid]==target){
                return new int[]{row,mid};
            }
            if(matrix[row][mid]<target){
                cstart = mid+1;
            }else{
                cend = mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] search(int[][] matrix,int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows==1){
            return binarySearch(matrix,0,0,cols-1,target);
        }

        int rStart = 0;
        int rEnd = rows-1;
        int cMid = cols/2;

        // run the loop till 2 rows are remaining
        while(rStart < (rEnd-1)){  //while this is true there'll be more than 2 rows
            int rmid = rStart + (rEnd-rStart)/2;
            if(matrix[rmid][cMid] == target){
                return new int[]{rmid,cMid};
            }
            if(matrix[rmid][cMid]<target){
                rStart = rmid;
            }else{
                rEnd = rmid;
            }
        }
        //Now we have two rows to check
        // Check whether the target is in the col of 2 rows
        if(matrix[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }
        if(matrix[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }

        //search in the 1st half
        if(matrix[rStart][cMid-1] >= target){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }
        //search in the second half
        if(matrix[rStart][cMid+1] <= target && target<=matrix[rStart][cols-1]){
            return binarySearch(matrix,rStart,cMid+1,cols-1,target);
        }
        //search in the third half
        if(matrix[rStart+1][cMid-1] >= target){
            return binarySearch(matrix,rStart+1,0,cMid-1,target);
        }
        //search in the fourth half
        else{
            return binarySearch(matrix,rStart+1,cMid+1,cols-1,target);
        }

    }
}
