package twoPointers_SlidingWindow;

public class L980_BinarySubArrayWithSum {

    public static void main(String[] args) {

    }

    public int findSumArraysLessThanOrEqual(int[] nums, int goal){
        int ans = 0;
        int left = 0;
        int sum = 0;
        if(goal < 0){
            return 0;
        }
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum > goal){
                sum -= nums[left++];
            }
            ans += (right - left + 1);
        }

        return ans;
    }


     public int numSubarraysWithSum(int[] nums, int goal) {
         int ans = 0;
         int right = nums.length - 1;
         int lastOne = nums.length;
         int sum = 0;
         for(int left = nums.length-1; left>=0; left--){
             sum += nums[left];
             if(lastOne > right && nums[left] == 1){
                 lastOne = left;
             }
             if(sum > goal){
                 right = lastOne - 1;
                 sum--;
                 lastOne--;
                 while(lastOne >= left && nums[lastOne] == 0) lastOne--;
                 if(lastOne < left) lastOne = nums.length;
             }

             if(sum == goal){
                 if(lastOne <= right){
                     ans += (right - lastOne + 1);
                 }else{
                     ans += (right-left+1);
                 }
             }

         }

         return ans;

     }
}
