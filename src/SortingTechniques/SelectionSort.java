package SortingTechniques;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {14,54,5,66,87,34,56,89,0};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    //-->Selection Sort <--
    //This sorting algorithm finds the maximum element for a section of
    // array and it'll place the max element in the last index of that section for every iteration
    static void selectionSort(int[] array) {

        for(int i=0;i<array.length;i++) {
            int last = array.length-1-i;
            int maxIndex=getmaximumIndex(array, 0, last);
            swap(array,maxIndex,last);
        }

    }
    static int getmaximumIndex(int[] array,int start,int end) {
        int max = start;
        for(int i=start;i<=end;i++) {
            if(array[i]>array[max])
                max = i;
        }
        return max;
    }

    public static void swap(int[] array,int first,int second) {
        int temp = array[first];
        array[first]=array[second];
        array[second]=temp;
    }
}
