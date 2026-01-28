package stacks_queues.leetcodeProblems;

import java.util.Stack;

public class L503_NextGreaterElement2 {

    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i = nums.length*2; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%nums.length]){
                stack.pop();
            }
            if(i < nums.length){
                ans[i] = (stack.isEmpty())? -1 : stack.peek();
            }
            stack.push(nums[i%nums.length]);
        }

        return ans;

    }

    public static int[] nextGreaterElements1(int[] nums) {
        int start = findMaxIndex(nums);
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[nums.length];


        for(int i=0; i< nums.length; i++){

            while(!stack.isEmpty() && stack.peek() <= nums[start]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[start] = -1;
                stack.push(nums[start]);
            }else{
                ans[start] = stack.peek();
                stack.push(nums[start]);
            }

            start--;
            if(start == -1){
                start = nums.length-1;
            }
        }

        return ans;
    }

    public static int findMaxIndex(int[] nums){
        int maxElement = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i=0; i< nums.length; i++){
            if(nums[i] >= maxElement){
                maxElement = nums[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
