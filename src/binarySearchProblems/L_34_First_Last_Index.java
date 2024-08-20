package binarySearchProblems;

import java.util.Arrays;

public class L_34_First_Last_Index {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums,8)));
    }

    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
   public static int[] searchRange(int[] nums,int target){
        int[] ans = {-1,-1};
        ans[0] = findIndex(nums,target,true);
        if(ans[0]!=-1){     //First occurrence not found means there is no target in that array
            ans[1] = findIndex(nums,target,false);
        }
        return ans;
   }

   public static int findIndex(int[] nums,int target,boolean firstOccurrence){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
       while(start<=end) {
           int mid = start+(end-start)/2;

           if(nums[mid]<target) {
               start = mid+1;
           }
           else if(nums[mid]>target) {
               end = mid-1;
           }
           else {
               ans = mid; //It may be the potential answer but check for the first or last occurrences
               if(firstOccurrence){
                   end = mid-1;
               }else{
                   start = mid+1;
               }

           }
       }

       return ans;
   }
}
