package arrayProblems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L27_RemoveElement {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(removeElement(nums,1));
    }


    // https://leetcode.com/problems/remove-element/submissions/1499599126/
    public  static int removeElement(int[] nums, int val) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val) nums[i] = Integer.MIN_VALUE;
        }
        int i=0,j=nums.length-1;
        while(i<=j){
            if(nums[i]==Integer.MIN_VALUE){
                while(nums[j]==Integer.MIN_VALUE && i<j){
                    j--;
                }
                swap(nums,i,j);
                j--;
            }else{
                i++;
            }
        }

//        System.out.println(Arrays.toString(nums));

        return i;
    }

    public static void swap(int[] nums,int first,int last){
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }

}
