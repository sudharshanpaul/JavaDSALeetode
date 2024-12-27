package SortingTechniques.Leetcode_Prblms;

import java.util.Arrays;

public class L_645_Set_Mismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    //https://leetcode.com/problems/set-mismatch/description/
    public static int[] findErrorNums(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }else{
                i++;
            }
        }
        for(i=0;i<nums.length;i++){
            if(i!=nums[i]-1){
                return new int[]{nums[i],i+1};
            }
        }
        return new int[]{-1,-1};
    }

    public static void swap(int[] arr,int first,int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
