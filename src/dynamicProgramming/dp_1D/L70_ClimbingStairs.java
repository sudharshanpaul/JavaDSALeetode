package dynamicProgramming.dp_1D;

import java.util.Arrays;

public class L70_ClimbingStairs {

    static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);
        return helper(n, ways);

        // ways[0] = 1;
        // ways[1] = 1;
        // for(int i=2; i<= n; i++){
        //     ways[i] = ways[i-1] + ways[i-2];
        // }
        // return ways[n];

        // int prev2 = 1;
        // int prev = 1;
        // for(int i=2; i<=n; i++){
        //     int present =  prev + prev2;
        //     prev2 = prev;
        //     prev = present;
        // }
        // return prev;
    }
    public int helper(int n, int[] ways){
        if(n == 0 || n == 1){
            return 1;
        }
        ways[n-1] = (ways[n-1] == -1)? helper(n-1, ways):ways[n-1];
        ways[n-2] = (ways[n-2] == -1)? helper(n-2, ways):ways[n-2];

        return ways[n] = ways[n-1] + ways[n-2];

    }
}
