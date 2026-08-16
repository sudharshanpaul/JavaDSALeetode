package dynamicProgramming.dp_1D;

import java.util.Arrays;

public class L198_HouseRobber {

    static void main(String[] args){

    }

    public static int rob(int[] nums){
        // -----> memoization
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return helper(nums, dp, nums.length-1);

        // ----> Tabulation

        // int[] costs = new int[nums.length];
        // Arrays.fill(costs, -1);
        // if(nums.length == 1){
        //     return nums[0];
        // }
        // if(nums.length == 2){
        //     return Math.max(nums[0], nums[1]);
        // }
        // costs[0] = nums[0];
        // costs[1] = nums[1];
        // costs[2] = nums[2] + nums[0];
        // for(int i=3; i< nums.length; i++){
        //     costs[i] = nums[i] + Math.max(costs[i-2], costs[i-3]);
        // }

        // return Math.max(costs[nums.length - 1], costs[nums.length - 2]);
        if(nums.length == 1){
            return nums[0];
        }
        // if(nums.length == 2){
        //     return Math.max(nums[0], nums[1]);
        // }
        // int a = nums[0];
        // int b = nums[1];
        // int c = nums[2] + a;
        // for(int i=3; i<nums.length; i++){
        //     int temp = nums[i] + Math.max(a, b);
        //     a = b;
        //     b = c;
        //     c = temp;
        // }

        // return Math.max(b, c);


        // ----> Space Optimization
        int a = nums[0];
        int b = Math.max(nums[1], a);
        for(int i=2; i<nums.length; i++){
            int temp = Math.max(b, nums[i] + a);
            a = b;
            b = temp;
        }

        return b;
    }

    // --> Memoization
    public static int helper(int[] nums, int[] dp, int index){
        if(index < 0){
            return 0;
        }
        if(index == 0){
            return dp[0] = nums[0];
        }
        if(dp[index] != -1){
            return dp[index];
        }

        int pick = nums[index] + helper(nums, dp, index - 2);
        int not_pick = helper(nums, dp, index - 1);

        return dp[index] = Math.max(pick, not_pick);
    }
}
