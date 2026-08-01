package dynamicProgramming.dp_1D;

public class L3693_ClimbingStairs2 {

    static void main(String[] args) {

    }

    public int climbStairs(int n, int[] costs) {
        // int[] solution = new int[n+1];
        // Arrays.fill(solution, -1);
        // return helper(n, costs, solution);

        // if(n == 1){
        //     return costs[0] + 1;
        // }

        // solution[0] = 0;
        // solution[1] = costs[0] + 1;
        // solution[2] = Math.min(costs[1] + 1 + solution[1], costs[1] + 4);

        // for(int i=3; i<=n; i++){
        //     solution[i] = minimum(costs[i-1] + 1 + solution[i - 1],
        //                           costs[i-1] + 4 + solution[i - 2],
        //                           costs[i-1] + 9 + solution[i - 3]);
        // }

        // return solution[n];

        if(n == 1){
            return costs[0] + 1;
        }
        int prevThree = 0;
        int prevTwo= costs[0] + 1;
        int prevOne = Math.min(costs[1] + 1 + prevTwo, costs[1] + 4);

        for(int i=3; i<=n; i++){
            int present = minimum(costs[i-1] + 1 + prevOne,
                    costs[i-1] + 4 + prevTwo,
                    costs[i-1] + 9 + prevThree);
            prevThree = prevTwo;
            prevTwo = prevOne;
            prevOne = present;
        }

        return prevOne;
    }

    public int helper(int n, int[] costs, int[] solution){
        if(n == 0) return 0;
        if(n == 1) return costs[0] + 1;
        if(n == 2){
            int one = costs[n - 1] + 1 + helper(n-1, costs, solution);
            int two = costs[n - 1] + 4;
            return solution[2] = Math.min(one, two);
        }
        if(solution[n - 1] == -1){
            solution[n - 1] = helper(n-1, costs, solution);
        }if(solution[n-2] == -1){
            solution[n - 2] = helper(n - 2, costs, solution);
        }if(solution[n - 3] == -1){
            solution[n - 3] = helper(n-3, costs, solution);
        }
        int one = costs[n-1] + 1 + solution[n - 1];
        int two = costs[n-1] + 4 + solution[n - 2];
        int three = costs[n-1] + 9 + solution[n - 3];

        return solution[n] = minimum(one, two, three);
    }

    public int minimum(int one, int two, int three){
        if(one <= two && one <= three){
            return one;
        }
        if(two <= one && two <= three){
            return two;
        }
        return three;
    }
}
