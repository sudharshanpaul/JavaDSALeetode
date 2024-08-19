package binarySearchProblems;

public class CeilingAndFlooring {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,6,7};
        System.out.println(floorNumber(arr,5));
    }
    //Ceiling of a number
    // For a given sorted array ceiling of a number means smallest number which is greater than or equals to the
    //target element
    public static int ceilingNumber(int[] array,int target){
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(array[mid]==target){
                return mid; //If a target iss found return that number
            }
            if(array[mid]>target){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return start; //If target is not found then start will stop at the ceiling function
    }

    //Floor of a number: Greatest number that is smaller or equal to that number
    public static int floorNumber(int[] array,int target){
        int start = 0;
        int end = array.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(array[mid]==target){
                return mid; //If a target iss found return that number
            }
            if(array[mid]>target){
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return end; //If target is not found then start will stop at the ceiling function
    }
}
