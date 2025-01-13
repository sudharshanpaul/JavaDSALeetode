package back_Tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class L40_CombinationSum2 {

    public static void main(String[] args) {

        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates,8));

    }

    // https://leetcode.com/problems/combination-sum-ii/?envType=problem-list-v2&envId=backtracking
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates,target,new ArrayList<>(),0,0);
    }

    public static List<List<Integer>> helper(int[] candidates,int target,List<Integer> list,int currentSum,int index){
        List<List<Integer>> ans = new ArrayList<>();
        if(currentSum == target){
            ans.add(new ArrayList<>(list));
            return ans;
        }

        for(int i=index;i<candidates.length;i++){
            if(i > index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(currentSum+candidates[i]<=target){
                list.add(candidates[i]);
                ans.addAll(helper(candidates,target,list,currentSum+candidates[i],i+1));
                list.removeLast();
            }
        }

        return ans;

    }

}
