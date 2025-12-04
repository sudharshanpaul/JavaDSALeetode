package bitManipulation.leecodeProblems;

import java.util.Arrays;
import java.util.HashMap;

public class L137_SingleNumber2 {

    public static void main(String[] args) {

    }

// https://leetcode.com/problems/single-number-ii/
    // Optimal - Best Solution using "Buckets"
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for(int num: nums){
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;

    }

    // Optimized

    public int singleNumber3(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i< nums.length; i+=3){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }

        return nums[nums.length - 1];

    }
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++){
            int count = 0;
            for(int num: nums){
                if((num & (1 << i)) != 0){  // See if the bit is Set or Not
                    count++;
                }
            }
            if(count % 3 == 1){
                ans = (ans | (1<<i));
            }
        }

        return ans;

    }

    // Brute Force
    public static int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        for(int num: nums){
            if(map.get(num) == 1){
                return num;
            }
        }

        return 0;

    }
}
