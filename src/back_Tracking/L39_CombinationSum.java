package back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class L39_CombinationSum {
    public static void main(String[] args) {

        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates,7));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        return helper(candidates,target,list,0,0);
    }

    public static List<List<Integer>> helper(int[] candidates,int target,List<Integer> list,int currentSum,int index){
        List<List<Integer>> ans = new ArrayList<>();
        // We should not use ans.add(list) because as list is an immutable datatype.. generally the
        // Reference of the list is passed so the further modifications in the list are happened so
        //we'll get empty list.. So add a copy of the answer
        if(currentSum == target){
            ans.add(new ArrayList<>(list));
            return ans;
        }
        for(int i=index;i<candidates.length;i++){
            if(currentSum+candidates[i] <= target){
                list.add(candidates[i]);
                ans.addAll(helper(candidates,target,list,currentSum+candidates[i],i));
                list.removeLast();
            }
        }

        return ans;

    }
}
