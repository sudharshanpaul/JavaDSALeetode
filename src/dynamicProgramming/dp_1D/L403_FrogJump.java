package dynamicProgramming.dp_1D;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class L403_FrogJump {

    static void main(String[] args) {

    }

    public boolean canCross(int[] stones) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Set<Integer>> map2 = new HashMap<>();
        for(int i=0; i< stones.length; i++){
            map.put(stones[i], i);
            map2.put(stones[i], new HashSet<Integer>());
        }
        if(stones[1] == 1){
            map2.get(1).add(1);
            return helper(1, stones[1], map, map2);
        }

        return false;
    }

    public boolean helper(int step, int value, HashMap<Integer, Integer> map, HashMap<Integer, Set<Integer>> map2){
        boolean ans = false;
        if(map.get(value) == map.size()-1){
            return true;
        }
        for(int i=-1; i<2; i++){
            int subValue = value + step + i;
            if(map.containsKey(subValue) && subValue > value && !map2.get(subValue).contains(step+i)){
                map2.get(subValue).add(step+i);
                ans = ans || helper(step+i, subValue, map, map2);
            }
        }

        return ans;
    }
}
