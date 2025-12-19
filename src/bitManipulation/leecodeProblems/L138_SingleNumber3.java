package bitManipulation.leecodeProblems;

import java.util.Arrays;

public class L138_SingleNumber3 {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {
        int totalXor = 0;
        for(int num: nums){
            totalXor = totalXor ^ num;
        }

        int bucket1 = 0;
        int bucket2 = 0;
        int firstDifferBit = findFirstBitDifference(totalXor);

        for(int num : nums){
            if(isSet(num, firstDifferBit)!=0){
                bucket1 = bucket1 ^ num;
            }else{
                bucket2 = bucket2 ^ num;
            }
        }

        return new int[]{bucket1, bucket2};

    }

    public static int findFirstBitDifference(int num){
        return (num & (num - 1)) ^ num;
    }

    public static int isSet(int num, int posNum){
        return num & posNum;
    }
}
