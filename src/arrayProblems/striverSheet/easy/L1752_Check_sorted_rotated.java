package arrayProblems.striverSheet.easy;

public class L1752_Check_sorted_rotated {

    // https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
    public boolean check(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int first = nums[0];
        int i, j;
        for(i=1,j=0; i< nums.length; i++,j++){
            if(nums[i]<nums[j]){
                break;
            }
        }
        i++;
        j++;
        while(j < nums.length){
            if(i < nums.length && nums[j] > nums[i]){
                return false;
            }
            if(nums[j] > first){
                return false;
            }
            i++;j++;
        }

        return true;
    }
}
