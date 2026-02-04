package stacks_queues.leetcodeProblems;

import java.util.Arrays;
import java.util.Stack;

public class L907_SumOfSubarrayMinimum {

    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(Arrays.toString(findNextSmaller(arr)));
    }

    public static int[] findNextSmaller(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i=arr.length -1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            ans[i] = (stack.isEmpty())? -1: stack.peek();
            stack.push(i);
        }
        return ans;
    }

    // brute force
    public int sumSubarrayMins(int[] arr) {
        long ans = 0;

        for(int i=0; i< arr.length; i++){
            long min = arr[i];
            for(int j=i; j< arr.length; j++){
                min = Math.min(min, arr[j]);
                ans += min;
            }
        }

        return (int)(ans % (Math.pow(10, 9)+7));
    }
}
