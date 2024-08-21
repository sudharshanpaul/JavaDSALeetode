package binarySearchProblems;

public class L_162_Find_Peak_Element {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,3,2};
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start!=end){
            int mid = start + (end-start)/2;
            if(nums[mid]>=nums[mid+1]){
                end = mid;      //As mid is greater there is a possibility that it is the peak
            }else{
                start = mid+1;  // As mid is smaller than the next element so peak should be in the second part
            }
        }
        return start;  //We can return anything either start, end or mid
    }
}
