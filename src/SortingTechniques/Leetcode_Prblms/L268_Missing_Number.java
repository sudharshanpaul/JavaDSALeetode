package SortingTechniques.Leetcode_Prblms;

import java.util.Arrays;

public class L268_Missing_Number {

    public static void main(String[] args) {

        int[] arr = {0,1};
        System.out.println(missingNumber(arr));
    }

    // https://leetcode.com/problems/missing-number/description/
    public static int missingNumber(int[] nums) {
        int[] arr = new int[nums.length+1];
        Arrays.fill(arr,-1);
        for(int i:nums){
            arr[i] = i;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                return i;
            }
        }
        return -1;
    }

}
