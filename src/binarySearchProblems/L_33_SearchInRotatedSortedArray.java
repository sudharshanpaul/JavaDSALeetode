package binarySearchProblems;

public class L_33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
          int[] nums = {2,9,2,2,2,2};
        System.out.println(search(nums,9));
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

    public static int search2(int nums[],int target){
        int pivot = findPivot(nums);
        if(pivot==-1){
            //Just do normal binary Search because it is not Rotated
            return binarySearch(nums,0, nums.length-1,target);
        }
        //If pivot is found means you found 2 sorted arrays
        if(nums[pivot]==target){
            return pivot;
        }

        if(target>=nums[0]){
            return binarySearch(nums,0,pivot-1,target);
        }
        return binarySearch(nums,pivot+1,nums.length-1,target);
    }


    //Finding pivot :Pivot is the largest element in the rotated sorted array
    public static int findPivot(int[] array){
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && array[mid]>array[mid+1]){
                return mid;
            }
            if(mid>start && array[mid]<array[mid-1]){
                return mid-1;
            }
            if(array[mid]<=array[start]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return -1;
    }
    public static int pivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        if(nums[end]>nums[start]){
            return end;
        }
        while(start!=end){
            int mid = start + (end-start)/2;
            if(nums[mid]<nums[mid+1]){
                return mid;
            }
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

    // Above things not work like {2,9,2,2,2,2}
    public static int findPivotWithDuplicates(int[] array){
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid<end && array[mid]>array[mid+1]){
                return mid;
            }
            if(mid>start && array[mid]<array[mid-1]){
                return mid-1;
            }
            // If elements at middle,start,end are equal so skip those duplicates
            if(array[mid]==array[start]&&array[mid]==array[end]){
                //Skip the duplicates
                if(array[start]>array[start+1]){
                    return start;
                }
                start++;
                //Check whether the end is pivot
                if(array[end]<array[end-1]){
                    return end-1;
                }
                end--;
            }
            //Left side is sorted, so pivot should be in right
            else if(array[start]<array[mid] || (array[start]==array[mid] && array[mid]>array[mid])){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }

}
