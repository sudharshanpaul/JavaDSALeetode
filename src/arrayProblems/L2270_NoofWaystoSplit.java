package arrayProblems;

public class L2270_NoofWaystoSplit {

    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};
        System.out.println(waysToSplitArray2(nums));
    }

    //https://leetcode.com/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-03
    public static int waysToSplitArray(int[] nums) {

        if(nums.length<2){
            return 0;
        }
        long[] prefixSum = new long[nums.length];
        int count = 0;
        long sum = 0;
        for(int i=nums.length-1;i>=0;i--){
            prefixSum[i] = nums[i] + (i < nums.length - 1 ? prefixSum[i + 1] : 0);
        }

        for(int i=0;i<nums.length-1;i++){
            sum += nums[i];
            if(sum>=prefixSum[i+1]){
                count++;
            }
        }

        return count;
    }

    public static int waysToSplitArray2(int[] nums) {

        long totalSum = 0;
        long sum = 0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }

        for(int i=0;i<nums.length-1;i++){
            sum += nums[i];
            totalSum-=nums[i];
            if(sum>=totalSum) count++;
        }

        return count;
    }

}
