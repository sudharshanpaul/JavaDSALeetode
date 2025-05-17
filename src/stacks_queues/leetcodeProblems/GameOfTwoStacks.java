package stacks_queues.leetcodeProblems;

import java.util.Stack;

public class GameOfTwoStacks {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(6);
        stack1.push(4);
        stack1.push(2);
        stack1.push(4);

        Stack<Integer> stack2 = new Stack<>();
        stack2.push(5);
        stack2.push(8);
        stack2.push(1);
        stack2.push(2);

        System.out.println(findMaxRemovals(stack1,stack2, 10));


    }

    public static int findMaxRemovals(Stack<Integer> stack1, Stack<Integer> stack2, int maxSum){
        return helper(stack1, stack2, maxSum, 0, 0);
    }

    private static int helper(Stack<Integer> stack1, Stack<Integer> stack2, int maxSum, int count, int sum){
        int finalAns = count;

        if(!stack1.empty() && sum+stack1.peek() <= maxSum){
            int num = stack1.pop();
            int parAns = helper(stack1, stack2, maxSum, count+1, sum+num);
            finalAns = Math.max(finalAns, parAns);
            stack1.push(num);
        }
        if(!stack2.empty() && sum+stack2.peek() <= maxSum){
            int num = stack2.pop();
            int parAns = helper(stack1, stack2, maxSum, count+1, sum+num);
            finalAns = Math.max(finalAns, parAns);
            stack2.push(num);
        }

        return finalAns;
    }


    public static int helper2(Stack<Integer> stack1,Stack<Integer> stack2, int maxSum, int count, int sum){
        if(sum > maxSum){
            return count;
        }
        int finalAns = count;
        if(!stack1.empty()){
            int num = stack1.pop();
            int ans1 = helper2(stack1, stack2, maxSum, count+1, sum+num);
            finalAns = Math.max(finalAns, ans1);
            stack1.push(num);
        }
        if(!stack2.empty()){
            int num = stack2.pop();
            int ans2 = helper2(stack1, stack2, maxSum, count+1, sum+num);
            finalAns = Math.max(finalAns, ans2);
            stack2.push(num);
        }

        return finalAns;
    }




}


