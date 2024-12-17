package SortingTechniques;

import java.util.Arrays;

public class Cyclic_Sort {
    // When given numbers are range from 1 to N use cyclic Sort
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    //After sorting
    // 1, 2, 3, 4, 5...> index = value-1 because index value starts from 0

    public static void sortArray(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
    }

    // This will work for [m,n]
    public static void cyclicSort(int[] arr){
        int min_value = min_of_arr(arr);
        int i=0;
        while(i<arr.length){
            if(arr[i]-min_value != i){
                swap(arr,i,arr[i]-min_value);
            }else{
                i++;
            }
        }
    }



    public static void cyclicSort2(int[] arr){
        int min_value = min_of_arr(arr);
        for(int i=0;i<arr.length;i++){
            while(arr[i]-min_value!=i){
                swap(arr,i,arr[i]-min_value);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp =arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int min_of_arr(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }
}
