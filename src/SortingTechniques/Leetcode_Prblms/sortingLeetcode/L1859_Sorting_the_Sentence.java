package SortingTechniques.Leetcode_Prblms.sortingLeetcode;

import java.util.Arrays;

public class L1859_Sorting_the_Sentence {

    public static void main(String[] args) {

        System.out.println(sortSentence("is2 sentence4 This1 a3"));

    }

    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        quickSort(words,0,words.length-1);
        String ans = "";
        for(String str:words){
            ans += str.substring(0,str.length()-1)+" ";
        }
        return ans.substring(0,ans.length()-1);
    }

    public static void quickSort(String[] array,int low,int high) {
        if(low>high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start)/2;
        int pivot = array[mid].charAt(array[mid].length() - 1) - '0';
        while(start<=end) {
            //also the reason why if it already sorted it will not swap
            while(array[start].charAt(array[start].length()-1)-'0'<pivot) {
                start++;
            }
            while(array[end].charAt(array[end].length()-1)-'0'>pivot) {
                end--;
            }
            if(start<=end) {
                String temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        // Now my pivot is at correct position now sort the remaining two parts;
        quickSort(array,low,end);
        quickSort(array,start,high);
    }

}
