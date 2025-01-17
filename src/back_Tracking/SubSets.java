package back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public static void main(String[] args) {

        List<Integer> p = new ArrayList<>();
        int[] up = {1,2,3};
        System.out.println(subSets(p,up,0));
    }

    // Finding Subsets of a given Array;
    public static List<List<Integer>> subSets(List<Integer> p,int[] up,int digit){
        List<List<Integer>> ans = new ArrayList<>();
        if(digit == up.length){
            ans.add(new ArrayList<>(p));
            return ans;
        }
        ans.addAll(subSets(p,up,digit+1));
        p.add(up[digit]);
        ans.addAll(subSets(p,up,digit+1));
        p.removeLast();
        return ans;
    }

}
