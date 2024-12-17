package SortingTechniques.Leetcode_Prblms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class L448_MissingAllNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]>nums.length){
                i++;
            }
            else if(nums[i]-1 != i && nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
            }else{
                i++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(i=0;i<nums.length;i++){
            if(nums[i]-1 != i){
                ans.add(i+1);
            }
        }
        return ans;
    }
    public static void swap(int[] arr,int first,int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }

}
