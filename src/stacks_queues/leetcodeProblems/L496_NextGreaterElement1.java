package stacks_queues.leetcodeProblems;

import java.util.HashMap;
import java.util.Stack;

public class L496_NextGreaterElement1 {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreat = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextGreat[i] = -1;
                stack.push(nums2[i]);
            }else{
                nextGreat[i] = stack.peek();
                stack.push(nums2[i]);
            }
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = nextGreat[findIndex(nums2, nums1[i])];
        }

        return ans;
    }

    public int findIndex(int[] arr, int num){
        for(int i=0; i< arr.length; i++){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }

    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(nums2[i], -1);
                stack.push(nums2[i]);
            }else{
                map.put(nums2[i], stack.peek());
                stack.push(nums2[i]);
            }
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = findNextGreat(nums2, findJ(nums2, nums1[i]), nums1[i]);
        }

        return ans;
    }

    public int findJ(int[] arr, int val){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == val){
                return i;
            }
        }
        return -1;
    }

    public int findNextGreat(int[] arr, int pos, int val){
        for(int i=pos; i< arr.length; i++){
            if(arr[i] > val){
                return arr[i];
            }
        }
        return -1;
    }
}
