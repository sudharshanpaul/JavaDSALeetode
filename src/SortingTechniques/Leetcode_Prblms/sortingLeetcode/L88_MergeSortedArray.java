package SortingTechniques.Leetcode_Prblms.sortingLeetcode;

import java.util.Arrays;

public class L88_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    // https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=sorting
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastIndex1 = nums1.length-1;
        --m;
        --n;
        while(lastIndex1>=0 && n>=0 && m>=0){
            if(nums1[m]<nums2[n]){
                nums1[lastIndex1] = nums2[n--];
            }else{
                nums1[lastIndex1] = nums1[m];
                nums1[m--] = 0;
            }
            lastIndex1--;
        }
        if(n<0) return;
        while(lastIndex1>=0){
            nums1[lastIndex1--] = nums2[n--];
        }
    }
}
