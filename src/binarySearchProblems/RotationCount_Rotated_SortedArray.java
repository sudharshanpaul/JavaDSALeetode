package binarySearchProblems;

public class RotationCount_Rotated_SortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(countRotations(nums));
    }

    public static int countRotations(int[] nums){
        int start = 0;
        int end = nums.length-1;
        if(nums[0]<nums[end]){
            return (end+1)%nums.length;
        }
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[mid+1]){
                return (mid+1)%nums.length;
            }
            if(nums[mid]>=nums[start]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
