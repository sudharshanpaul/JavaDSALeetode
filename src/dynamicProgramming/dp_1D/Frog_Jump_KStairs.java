package dynamicProgramming.dp_1D;

import java.util.Arrays;

public class Frog_Jump_KStairs {

    static void main(String[] args) {
        int[] height = {10, 30, 40, 20};
        int k = 2;
        System.out.println(minCost(height, k));
    }

    public static int minCost(int[] height, int k){
        int[] costs = new int[height.length];
        Arrays.fill(costs, -1);
        return helper(height, costs, k, height.length - 1);
    }

    public static int helper(int[] height,  int[] costs, int k, int step){
        int ans = Integer.MAX_VALUE;

        if(step == 0){
            return costs[0] = 0;
        }

        if(costs[step] != -1){
            return costs[step];
        }

        for(int i=1; i <= k; i++){
            if(step - i >= 0) {
                ans = Math.min(ans, Math.abs(height[step] - height[step - i]) + helper(height, costs, k, step - i));
            }
        }

        return costs[step] = ans;
    }
}
