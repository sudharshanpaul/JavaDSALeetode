package back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class L46_Permutations {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        System.out.println(permute2(new ArrayList<>(),nums));

    }
    public List<List<Integer>> permute7(int[] nums) {
        List<Integer> up = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        for(int num:nums){
            up.add(num);
        }
        return helper7(p,up);
    }

    public List<List<Integer>> helper7(List<Integer> p,List<Integer> up){
        List<List<Integer>> ans = new ArrayList<>();

        if(up.size()==0){
            ans.add(p);
            return ans;
        }

        for(int i=0;i<=p.size();i++){
            List<Integer> inner = new ArrayList<>(p.subList(0,i));
            inner.add(up.get(0));
            inner.addAll(p.subList(i,p.size()));

            ans.addAll(helper7(inner,up.subList(1,up.size())));
        }

        return ans;
    }

    public static List<List<Integer>> permute(int[] nums) {
        return helper(new ArrayList<>(),nums,0);
    }
    public static List<List<Integer>> helper(List<Integer> p,int[] up,int digit){
        List<List<Integer>> ans = new ArrayList<>();
        if(digit==up.length){
            ans.add(new ArrayList<>(p));
            return ans;
        }
        for(int i=0;i<=p.size();i++){
            p.add(i,up[digit]);
            ans.addAll(helper(p,up,digit+1));
            p.remove(i);
        }

        return ans;
    }

    public static List<List<Integer>> permute2(List<Integer> p,int[] up){
        List<List<Integer>> ans = new ArrayList<>();
        if(p.size()==up.length){
            ans.add(new ArrayList<>(p));
            return ans;
        }
        for(int i=0;i<up.length;i++){
            if(p.contains(up[i])){
                continue;
            }
            p.add(up[i]);
            ans.addAll(permute2(p,up));
            p.removeLast();
        }
        return ans;
    }

}
