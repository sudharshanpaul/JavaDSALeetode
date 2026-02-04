package stacks_queues.leetcodeProblems;

import java.util.Stack;

public class L_SumOfSubArrayRanges {

    public static void main(String[] args) {

    }

    // BruteForce
    public long subArrayRanges2(int[] nums){
        long ans = 0;
        for(int i=0; i< nums.length; i++){
            long min = nums[i];
            long max = nums[i];
            for(int j=i; j< nums.length; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += (max-min);
            }
        }
        return ans;
    }



    // optimal Solution
    public long subArrayRanges(int[] nums) {

        return findSumSubArrayMaximum(nums) - findSumSubArrayMinimum(nums);
    }

    public long findSumSubArrayMaximum(int[] nums){
        long ans = 0;
        int[] nextGreater= findNextGreaterIndex(nums);
        int[] prevGreater = findPrevGreaterIndex(nums);

        for(int i=0; i< nums.length; i++){
            long length = (nextGreater[i] - i) * (i - prevGreater[i]);
            ans += length*nums[i];
        }
        return ans;
    }

    public int[] findNextGreaterIndex(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }
            ans[i] = (stack.isEmpty())?nums.length: stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public int[] findPrevGreaterIndex(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            ans[i] = (stack.isEmpty())?-1: stack.peek();
            stack.push(i);
        }
        return ans;
    }




    public long findSumSubArrayMinimum(int[] nums){
        long ans = 0;
        int[] nextSmaller = findNextSmallerIndex(nums);
        int[] prevSmaller = findPrevSmallerIndex(nums);

        for(int i=0; i< nums.length; i++){
            long length = (nextSmaller[i] - i) * (i - prevSmaller[i]);
            ans += length*nums[i];
        }
        return ans;
    }

    public int[] findNextSmallerIndex(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }
            ans[i] = (stack.isEmpty())?nums.length: stack.peek();
            stack.push(i);
        }
        return ans;
    }

    public int[] findPrevSmallerIndex(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            ans[i] = (stack.isEmpty())?-1: stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
