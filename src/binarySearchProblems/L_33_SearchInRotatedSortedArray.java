package binarySearchProblems;

public class L_33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
          int[] nums = {1,2,3,4,5};
        System.out.println(search(nums,1));
 //         System.out.println(pivot(nums));
    }



    // https://leetcode.com/problems/search-in-rotated-sorted-array/




    public static int search(int[] nums, int target) {
        //Base Case
//        int base = base(nums);
//        int ans = binarySearch(nums,0,base-1,target);
//        if(ans==-1){
//            ans = binarySearch(nums,base,nums.length-1,target);
//        }
//        return ans;

        // For pivot case
        int pivot = pivot(nums);
        int ans = binarySearch(nums,0,pivot,target);
        if(ans==-1){
            ans = binarySearch(nums,pivot+1,nums.length-1,target);
        }
        return ans;
    }

    //Finding pivot :Pivot is the largest element in the rotated sorted array
    public static int pivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        if(nums[end]>nums[start]){
            return end;
        }
        while(start!=end){
            int mid = start + (end-start)/2;
            if(nums[mid]>=nums[start]){
                start = mid;
            }else{
                end = mid-1;
            }
        }
        return start;
    }

    // In this function we'll find the base i.e the index where it became rotated sorted array
    public static int base(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(nums[start]>nums[end]){
            int mid = start + (end-start)/2;
            if(nums[mid]>=nums[start]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
    static int binarySearch(int[] array,int start,int end,int target) {

        while(start<=end) {
            //int middle = (start+end)/2;  int start+end exceeds if both the start and end values are too large
            int mid = start+(end-start)/2;
            if(array[mid]<target) {
                start = mid+1;
            }
            else if(array[mid]>target) {
                end = mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

}
