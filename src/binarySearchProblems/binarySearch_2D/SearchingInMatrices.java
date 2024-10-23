package binarySearchProblems.binarySearch_2D;

import java.util.Arrays;

public class SearchingInMatrices {
    public static void main(String[] args) {
//        int[][] array = {
//                {18,9,12},
//                {36,-4,91},
//                {44,33,16}
//        };
        int[][] array = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        System.out.println(Arrays.toString(searchRowColSorted(array,40)));
    }

    // Linear Search in 2D Array
    // Time Complexity is O(n^2) or O(n*m)
    public static int[] search2DRandom(int[][] array,int target){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(array[i][j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
    // If the array is Sorted Row wise and also the column wise then we can use this
    public static int[] searchRowColSorted(int[][] array,int target){
        int possRow=0, possCol=0;
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(array[mid][0]<=target && array[mid][array[0].length-1]>=target){
                possRow = mid;
                break;
            }
            else if(target < array[mid][0]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        start = 0;
        end = array[0].length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(array[0][mid]<=target && array[array.length-1][mid]>=target){
                possCol = mid;
                break;
            }
            else if(target < array[0][mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        int[] ans = binarySearch(array,target,true,possRow);
        if(ans!=null){
            return ans;
        }
        return binarySearch(array,target,false,possCol);
    }

    public static int[] binarySearch(int[][] array,int target,boolean isRow,int check){
        int start = 0;
        int end;
        if(isRow){
            end = array.length-1;
        }else{
            end = array[0].length-1;
        }
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isRow){
                if(array[check][mid]==target){
                    return new int[]{check,mid};
                }else if(array[check][mid]>target){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                if(array[mid][check]==target){
                    return new int[]{mid,check};
                }else if(array[mid][check]>target){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }
        return null;
    }
}
