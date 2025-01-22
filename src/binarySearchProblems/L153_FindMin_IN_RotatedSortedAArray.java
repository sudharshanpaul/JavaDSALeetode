package binarySearchProblems;

public class L153_FindMin_IN_RotatedSortedAArray {

    public static void main(String[] args) {

        int[] nums = {2,3,4,5,1};
        System.out.println(findMin(nums));

    }

    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/?envType=problem-list-v2&envId=binary-search
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start != end){
            int mid = start + (end - start)/2;
            if(nums[mid]>nums[end]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return nums[start];

    }

}
