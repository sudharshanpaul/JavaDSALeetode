package binarySearchProblems;

public class MyBinarySearch {
    //1.Find the middle element
    //2.if target>mid then search in thr right else search in the left
    //3.if middle element == target then the work is done

    //Order Agnostic Binary Search: This is used when the array is sorted in ascending or descending order
    public static void main(String[] args) {

        int[] array = {-18,-4,2,4,5,7,56,58,90,100,103};
        System.out.println(binarySearch(array, -18));
        int[] array1 = {15,2,1,0,-34,-43};
        System.out.println(agnosticBinarySearch(array1, 0));

    }

    //Returning the index -1 if not exist
    static int binarySearch(int[] array,int target) {
        int start=0,end = array.length-1;
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

    static int agnosticBinarySearch(int[] array,int target) {
        int start = 0;
        int end = array.length-1;

        boolean isAsc = array[start]<array[end];
        while(start<=end) {
            //int middle = (start+end)/2;  int start+end exceeds if both the start and end values are too large
            int mid = start+(end-start)/2;

            if(array[mid] == target) {
                return mid;
            }
            if(isAsc) {
                if(array[mid]<target) {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else {
                if(array[mid]>target) {
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;

    }
}
