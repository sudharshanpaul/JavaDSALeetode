package arrayProblems.striverSheet.easy;

public class L_136_SigleNumber {

    // https://leetcode.com/problems/single-number/description/

    public int singleNumber(int[] nums) {
        int ans = 0; // XOR (0, num) = num
        for(int num:nums){
            ans = ans ^ num;
        }

        return ans;
    }
}
