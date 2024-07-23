package SortingTechniques;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {14,54,5,66,87,34,56,89,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //-->Bubble Sort <--
    public static void bubbleSort(int[] array) {
        //Run the steps to n-1 times
        for(int i=0;i<array.length;i++) {
            boolean check = false;
            //For each step max element the max element comes to the last respective index
            for(int j=1;j<array.length-i;j++) {
                //swap if the item is smaller to the previous item
                if(array[j-1]>array[j]) {
                    swap(array,j-1,j);
                    check = true;
                }
            }
            if(!check)  //Stop the process if no swapping is done throughout the iteration because this happens only when the array is fully sorted
                return;
        }
    }

    // -->Swapping
    public static void swap(int[] array,int first,int second) {
        int temp = array[first];
        array[first]=array[second];
        array[second]=temp;
    }
}
