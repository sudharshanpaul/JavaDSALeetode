package recursionLeetcode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ProblemSet1 {
    public static void main(String[] args) {

        int[] nums = {1,2,2};
        List<List<Integer>> list = subsets(nums);
        for(List<Integer> l:list){
            System.out.println(l);
        }

    }

    //https://leetcode.com/problems/subsets/submissions/1326892274/ SubsetProblem
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n:nums){
            list.add(n);
        }

        return helper(new ArrayList<Integer>(),list);
    }

    private static List<List<Integer>>helper(List<Integer> p, List<Integer> up) {
        List<List<Integer>> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }

        List<Integer> inner = new ArrayList<>(p);
        inner.add(up.getFirst());
        list.addAll(helper(p,up.subList(1,up.size())));
        list.addAll(helper(inner,up.subList(1,up.size())));

        return list;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int num : nums) {
            int n = list.size();
            for (int j = 0; j < n; j++) {
                List<Integer> inner = new ArrayList<>(list.get(j));
                inner.add(num);
                list.add(inner);
            }
        }
        return list;
    }

    // https://leetcode.com/problems/subsets-ii/description/ SubSet with duplicate elements
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int start,end;
        end=0;
        list.add(new ArrayList<>());

        for(int i=0;i<nums.length;i++){
            int n = list.size();
            start = 0;
            if(i!=0 && nums[i]==nums[i-1]){
                start = end+1;
            }
            end = list.size()-1;
            for(int j=start;j<n;j++){
                List<Integer> inner = new ArrayList<>(list.get(j));
                inner.add(nums[i]);
                list.add(inner);
            }

        }

        return list;
    }
}
