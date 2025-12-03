package bitManipulation.leecodeProblems;

import java.util.ArrayList;
import java.util.List;

public class L78_SubSets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int finalLen = 1 << n;
        for(int i=0; i < finalLen; i++){
            List<Integer> inner = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(isSetAt(i, j)){
                    inner.add(nums[j]);
                }
            }
            ans.add(inner);
        }

        return ans;
    }

    public static boolean isSetAt(int num, int pos){
        return (num & (1<<pos)) != 0;
    }
}
