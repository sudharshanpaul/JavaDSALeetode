package back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class L77_Combinations {

    public static void main(String[] args) {

        System.out.println(combine1(4,2));

    }

    // https://leetcode.com/problems/combinations/?envType=problem-list-v2&envId=backtracking
    public static List<List<Integer>> combine(int n, int k) {
        return helper(n,k,new ArrayList<>(),1);
    }

    public static List<List<Integer>> helper(int n,int k,List<Integer> list,int index){
        List<List<Integer>> ans = new ArrayList<>();
        if(k == 0){
            ans.add(new ArrayList<>(list));
            return ans;
        }
        for(int i=index;i<=n;i++){
            list.add(i);
            ans.addAll(helper(n,k-1,list,i+1));
            list.removeLast();
        }

        return ans;

    }

    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper1(n,k,new ArrayList<>(),ans,1);
        return ans;
    }

    public static void helper1(int n,int k,List<Integer> list,List<List<Integer>> ans,int index){
        if(k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<=n;i++){
            list.add(i);
            helper1(n,k-1,list,ans,i+1);
            list.removeLast();
        }
    }

}
