package SortingTechniques.Leetcode_Prblms;

public class L_41_First_Missing_Positive {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }

    //https://leetcode.com/problems/first-missing-positive/description/
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(correct >= nums.length || nums[i]<=0){
                i++;
            }
            else if(nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }else{
                i++;
            }
        }

        for(i=0;i<nums.length;i++){
            if(i+1 != nums[i]){
                return i+1;
            }
        }

        return nums.length+1;
    }

    public static int findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }
    public static void swap(int[] arr,int first,int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
