package binarySearchProblems;

public class RotationCount_Rotated_SortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(rotationCount(nums));
    }
    public static int rotationCount(int[] nums){
        int pivot = findPivot(nums);
        return (pivot+1) % nums.length;
    }
    public static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        if(nums[0]<nums[end]){
            return end;
        }
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[mid+1]){
                return mid;
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
