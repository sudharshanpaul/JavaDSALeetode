package SortingTechniques.Leetcode_Prblms.sortingLeetcode;

import java.util.Arrays;

public class L2418_Sort_the_People {

    public static void main(String[] args) {

        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.toString(sortPeople(names,heights)));

    }

    // https://leetcode.com/problems/sort-the-people/?envType=problem-list-v2&envId=sorting
    public static String[] sortPeople(String[] names, int[] heights) {

        quickSort(heights,names,0,heights.length-1);
        return names;

    }

    public static void quickSort(int[] array,String[] names,int low,int high) {
        if(low>high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start)/2;
        int pivot = array[mid];
        while(start<=end) {
            //also the reason why if it already sorted it will not swap
            while(array[start]>pivot) {
                start++;
            }
            while(array[end]<pivot) {
                end--;
            }
            if(start<=end) {
                int temp = array[start];
                String tempStr = names[start];
                array[start] = array[end];
                names[start] = names[end];
                array[end] = temp;
                names[end] = tempStr;
                start++;
                end--;
            }
        }
        // Now my pivot is at correct position now sort the remaining two parts;
        quickSort(array,names,low,end);
        quickSort(array,names,start,high);
    }

}
