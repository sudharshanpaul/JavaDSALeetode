package bitManipulation.leecodeProblems;

public class L136_SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4,1,2,2,1};
        System.out.println(singleNumber(nums));
    }
// https://leetcode.com/problems/single-number/
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int num: nums){
            ans = ans ^ num;
        }

        return ans;
    }
}
