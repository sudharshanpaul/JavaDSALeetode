package dynamicProgramming.dp_1D;

public class GFG_Frog_Jujmp {

    static void main(String[] args) {

    }

    static int minCost(int[] height) {
        // code here
        if(height.length == 1){
            return 0;
        }

        int prev2 = 0;
        int prev = Math.abs(height[1] - height[0]);


        for(int i=2; i< height.length; i++){
            int left = prev + Math.abs(height[i] - height[i-1]);
            int right = prev2 + Math.abs(height[i] - height[i-2]);
            int temp = Math.min(left, right);
            prev2 = prev;
            prev = temp;

        }
        // return minCost2(height, height.length - 1, costs);

        // return costs[height.length -1];

        return prev;
    }

    public static int minCost2(int[] height, int step, int[] costs){

        if(step == 0){
            return 0;
        }
        if(step == 1){
            return costs[1] = Math.abs(height[step] - height[step - 1]);
        }

        if(costs[step] != -1){
            return costs[step];
        }

        int left = minCost2(height, step - 1, costs) + Math.abs(height[step] - height[step-1]);
        int right = minCost2(height, step - 2, costs) + Math.abs(height[step] - height[step-2]);

        return costs[step] = Math.min(left, right);


    }
}
