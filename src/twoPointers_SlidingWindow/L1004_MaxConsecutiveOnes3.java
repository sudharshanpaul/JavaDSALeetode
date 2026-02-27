package twoPointers_SlidingWindow;

public class L1004_MaxConsecutiveOnes3 {

    public static void main(String[] args) {

    }

    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int no_of_flips = 0;
        for(int right = 0; right < nums.length; right++){
            while(no_of_flips == k && nums[right] == 0){
                if(nums[left] == 0){
                    no_of_flips--;
                }
                left++;
            }
            no_of_flips = (nums[right] == 0)? no_of_flips + 1: no_of_flips;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public int longestOnes1(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int no_of_flips = 0;
        for(int right = 0; right < nums.length; right++){

            if(no_of_flips > k){
                if(nums[left] == 0){
                    no_of_flips--;
                }
                left++;
            }
            no_of_flips = (nums[right] == 0)? no_of_flips + 1: no_of_flips;
            if(no_of_flips <= k){
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
