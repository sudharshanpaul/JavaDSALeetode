package SortingTechniques.Leetcode_Prblms;

import java.util.Arrays;

public class L268_Missing_Number {

    public static void main(String[] args) {

        int[] arr = {1};
        System.out.println(missingNumber1(arr));
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

    public static int missingNumber1(int[] nums){
        int i=0;
        int min = minOfArray(nums);
        int max = maxOfArray(nums);
        while(i<nums.length){
            if(nums[i]==max){
                i++;
            }
            else if(nums[i]-min != i){
                swap(nums,nums[i]-min,i);
            }else{
                i++;
            }
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return nums[nums.length-1]+1;
    }


    // This function is from [m,n] array not from 0
    public static int missingNumber2(int[] nums){
        int i=0;
        int min = minOfArray(nums);
        int max = maxOfArray(nums);
        while(i<nums.length){
            if(nums[i]==max){
                i++;
            }
            else if(nums[i]-min != i){
                swap(nums,nums[i]-min,i);
            }else{
                i++;
            }
        }
        for(i=0;i<nums.length;i++){
            if(nums[i]-min!=i){
                return nums[i]-1;
            }
        }
        return nums[nums.length-1]+1;
    }
    public static void swap(int[] arr,int first,int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
    public static int minOfArray(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int num:arr){
            if(num<min){
                min = num;
            }
        }
        return min;
    }
    public static int maxOfArray(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int num:arr){
            if(num>max){
                max = num;
            }
        }
        return max;
    }

}
