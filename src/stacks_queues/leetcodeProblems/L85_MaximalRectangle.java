package stacks_queues.leetcodeProblems;

import java.util.Stack;

public class L85_MaximalRectangle {

    public static void main(String[] args) {

    }

    public int maximalRectangle(char[][] matrix) {
        int[][] histograms = prefixSum(matrix);
        int ans = 0;
        for(int i=0; i<histograms.length; i++){
            ans = Math.max(ans, maxRectangle(histograms, i));
        }

        return ans;
    }

    public int maxRectangle(int[][] arr, int row){
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr[0].length; i++){
            while(!stack.isEmpty() && arr[row][stack.peek()] > arr[row][i]){
                int height = arr[row][stack.pop()];
                int prevIndex = (stack.isEmpty())?-1:stack.peek();
                ans = Math.max(ans, (i-prevIndex-1)*height);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int height = arr[row][stack.pop()];
            int prevIndex = (stack.isEmpty())?-1:stack.peek();
            ans = Math.max(ans, (arr[0].length-prevIndex-1)*height);
        }

        return ans;
    }

    public int[][] prefixSum(char[][] matrix){
        int[][] ans = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix[0].length; i++){
            int prefixSum = 0;
            for(int j=0; j<matrix.length; j++){
                prefixSum = (matrix[j][i] == '0')? 0 : prefixSum + 1;
                ans[j][i] = prefixSum;
            }
        }

        return ans;
    }
}
