package arrayProblems.striverSheet.easy;

public class L_485_MaxconsecutiveOnes {
    // https://leetcode.com/problems/max-consecutive-ones/description/

    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int prevAns = 0;
        for(int num: nums){
            if(num == 1){
                ans++;
            }else{
                prevAns = Math.max(ans, prevAns);
                ans = 0;
            }
        }

        return Math.max(ans, prevAns);
    }
}
