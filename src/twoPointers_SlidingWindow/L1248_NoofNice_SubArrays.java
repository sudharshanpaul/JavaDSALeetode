package twoPointers_SlidingWindow;

public class L1248_NoofNice_SubArrays {

    public static void main(String[] args) {

    }

    public int numberOfSubarrays(int[] nums, int k) {
        return find(nums, k) - find(nums, k-1);
    }

    public int find(int[] nums, int k){
        int count = 0;
        int left = 0;
        int ans = 0;
        if(k < 0) return 0;
        for(int right = 0; right<nums.length; right++){
            count = (nums[right]%2 != 0)? count+1: count;
            while(count > k){
                if(nums[left++] % 2 != 0) count--;
            }
            ans += (right - left + 1);
        }

        return ans;

    }
}
