package twoPointers_SlidingWindow;

import java.util.HashMap;

public class L992_SubArraywithKDifferentIntegers {

    public static void main(String[] args) {

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return find(nums, k) - find(nums, k - 1);
    }

    public int find(int[] nums, int k){
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;

        if(k < 0) return 0;

        for(int right = 0; right<nums.length; right++){
            if(map.containsKey(nums[right])){
                map.put(nums[right], map.get(nums[right])+1);
            }else{
                map.put(nums[right], 1);
            }

            while(map.size() > k){
                map.put(nums[left], map.get(nums[left])-1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }

            ans += (right - left + 1);
        }

        return ans;
    }
}
