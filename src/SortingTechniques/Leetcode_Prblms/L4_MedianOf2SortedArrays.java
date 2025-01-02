package SortingTechniques.Leetcode_Prblms;


public class L4_MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays2(nums1,nums2));
    }

    // https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/1494625882/
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        while(i<nums1.length && j< nums2.length){
            if(nums1[i]<nums2[j]){
                ans[k] = nums1[i++];
            }else{
                ans[k]=nums2[j++];
            }
            k++;
        }
        while(i<nums1.length){
            ans[k++] = nums1[i++];
        }
        while(j<nums2.length){
            ans[k++] = nums2[j++];
        }

        if((nums1.length+nums2.length)%2==0){
            return (double) (ans[ans.length / 2] + ans[(ans.length / 2) - 1]) /2;
        }else{
            return  ans[(ans.length/2)];
        }
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length+nums2.length];
        int i=0,j=0;
        for(int k=0;k<ans.length;k++){
            if(i<nums1.length && (j>=nums2.length || nums1[i]<=nums2[j])){
                ans[k] = nums1[i++];
            }else{
                ans[k] = nums2[j++];
            }
        }

        if((nums1.length+nums2.length)%2==0){
            return (double) (ans[ans.length / 2] + ans[(ans.length / 2) - 1]) /2;
        }else{
            return  ans[(ans.length/2)];
        }
    }
}


