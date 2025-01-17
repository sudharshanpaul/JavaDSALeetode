package back_Tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47_Permutations2 {

    public static void main(String[] args) {

        int[] nums = {1,2,1};
        System.out.println(permuteUnique(nums));

    }

    // https://leetcode.com/problems/permutations-ii/?envType=problem-list-v2&envId=backtracking
    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),nums,new boolean[nums.length]);
        return ans;
    }

    public static void helper(List<List<Integer>> ans,List<Integer> p,int[] up,boolean[] used){
        if(p.size()==up.length && !ans.contains(p)){
            ans.add(new ArrayList<>(p));
            return;
        }
        for(int i=0;i<up.length;i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            p.add(up[i]);

            helper(ans,p,up,used);

            used[i]=false;
            p.removeLast();
        }
    }

}
