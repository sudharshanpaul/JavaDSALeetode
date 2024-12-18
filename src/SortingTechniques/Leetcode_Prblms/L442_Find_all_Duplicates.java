package SortingTechniques.Leetcode_Prblms;

import java.util.ArrayList;
import java.util.List;

public class L442_Find_all_Duplicates {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates((nums)));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        List<Integer> ans = new ArrayList<>();
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i] != nums[correct]){
                swap(nums,i,correct);
            }else{
                i++;
            }
        }
        for( i=0;i<nums.length;i++){
            if(nums[i]-1!=i){
                ans.add(nums[i]);
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
