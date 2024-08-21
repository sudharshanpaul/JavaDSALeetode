package binarySearchProblems;

public class L_852_PeakIndexMountainArr {
    public static void main(String[] args) {
        int[] arr = {0,2,3,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start!=end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end = mid;      //As mid is greater there is a possibility that it is the peak
            }else{
                start = mid+1;  // As mid is smaller than the next element so peak should be in the second part
            }
        }
        return start;  //We can return anything either start, end or mid
    }
}
