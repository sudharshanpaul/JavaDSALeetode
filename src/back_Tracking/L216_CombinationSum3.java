package back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class L216_CombinationSum3 {

    public static void main(String[] args) {

        System.out.println(combinationSum3(3,7));

    }

    // https://leetcode.com/problems/combination-sum-iii/?envType=problem-list-v2&envId=backtracking
    public static List<List<Integer>> combinationSum3(int k, int n) {
//        return helper(k,n,new ArrayList<>(),1);
        List<List<Integer>> ans = new ArrayList<>();
        helper1(ans,k,n,new ArrayList<>(),1);
        return ans;
    }

    public static List<List<Integer>> helper(int k,int target,List<Integer> list,int index){
        List<List<Integer>> ans = new ArrayList<>();
        if(target == 0 && k==0){
            ans.add(new ArrayList<>(list));
            return ans;
        }

        for(int i=index;i<=9;i++){
            if(target-i >= 0 && k>0){
                list.add(i);
                ans.addAll(helper(k-1,target-i,list,i+1));
                list.removeLast();
            }
        }
        return ans;
    }

    public static void helper1(List<List<Integer>> ans,int k,int target,List<Integer> list,int index){

        if(target == 0 && k==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=index;i<=9;i++){
            if(target-i >= 0 && k>0){
                list.add(i);
                helper1(ans,k-1,target-i,list,i+1);
                list.removeLast();
            }
        }
    }



}
