package dynamicProgramming;

public class L509_FibonacciSeries {

    static void main(String[] args) {

    }

    public int fib(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // dp[0] = 0;
        // dp[1] = 1;
        // for(int i=2; i<=n; i++){
        //     dp[i] = dp[i-1] + dp[i-2];
        // }

        // return dp[n];

        if(n <= 1){
            return n;
        }
        int ans = -1;
        int prev2 = 0;
        int prev1 = 1;
        for(int i=2; i<=n; i++){
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }
}
