package bitManipulation.leecodeProblems;

import java.util.Arrays;

public class L138_SingleNumber3 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[ ] nums) {
        int ones = 0;
        int twos = 0;
        int i=0;
        int[] ans = new int[2];
        for(int num: nums){
            int prevOne = ones;
            int prevTwo = twos;
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
            if(ones != prevOne && prevTwo == twos){
                ans[i] = num;
                i = (i+1) % 2;
            }else if(prevTwo != twos){
                i = findIndex(ans,num);
            }
        }

        return ans;
    }

    public static int findIndex(int[] ans, int num){
        if(ans[0] == num) return 0;
        return 1;
    }
}
