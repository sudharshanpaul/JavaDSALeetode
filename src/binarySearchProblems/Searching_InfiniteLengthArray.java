package binarySearchProblems;

public class Searching_InfiniteLengthArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,7,8,9,12,22,33,44,55,66,77,88,99,111};
        System.out.println(searchInInfinite(arr,8));
    }
    public static int searchInInfinite(int[] nums,int target){
        int start = 0;
        int end = 1;
        if(nums[start]>target)
            return -1;
        else{
            while(target>nums[end]){
                int newStart = end+1;
                // Double the box that you wanna search
                // end = previous end + sizeofBox*2
                end = end + (end-start+1)*2;
                start = newStart;
            }
        }
        return binarySearch(nums,start,end,target);
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
