package stacks_queues.leetcodeProblems;

import java.util.Arrays;
import java.util.Stack;

public class L84_LargestRectangleInHistgrams {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(Arrays.toString(prevSmaller(heights)));
    }

    public static int largestRectangleArea(int[] heights) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int height = heights[stack.pop()];
                int prevSmall = (stack.isEmpty())?-1:stack.peek();
                ans = Math.max(ans, (i - prevSmall - 1)*height);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int height = heights[stack.pop()];
            int prevSmall = (stack.isEmpty())?-1:stack.peek();
            ans = Math.max(ans, (heights.length - prevSmall - 1)*height);
        }

        return ans;
    }

    public static int largestRectangleArea1(int[] heights) {

        int[] nextSmaller = nextSmaller(heights);
        int[] prevSmaller = prevSmaller(heights);
        int ans = 0;

        for(int i=0; i<heights.length; i++){
            ans = Math.max((nextSmaller[i]-prevSmaller[i]-1)*heights[i], ans);
        }

        return ans;
    }

    public static int[] nextSmaller(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            ans[i] = (stack.isEmpty())?nums.length: stack.peek();
            stack.push(i);
        }

        return ans;
    }
    public static int[] prevSmaller(int[] nums){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            ans[i] = (stack.isEmpty())?-1: stack.peek();
            stack.push(i);
        }

        return ans;
    }
}
