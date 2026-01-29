package stacks_queues.leetcodeProblems;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {

    public static void main(String[] args) {
        int[] arr = {5,7,9,6,7,4,5,1,3,7};
        System.out.println(Arrays.toString(prevSmallerElement(arr)));
    }

    public static int[] prevSmallerElement(int[] arr){

        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i< arr.length; i++){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }

            ans[i] = (stack.isEmpty())? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return ans;
    }
}
