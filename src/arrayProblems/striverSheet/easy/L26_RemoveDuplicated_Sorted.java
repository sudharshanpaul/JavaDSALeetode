package arrayProblems.striverSheet.easy;

public class L26_RemoveDuplicated_Sorted {


    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public int removeDuplicatesOptimal(int[] nums) {
        int i=0, j=1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return nums.length;
        }
        for(int i=0, j=1; i < nums.length-1; i++, j++){
            if(nums[j] <= nums[i]){
                int nextElement = findNext(nums, j, findMax(nums[i], nums[j]));
                if(nextElement == findMax(nums[i], nums[j])){
                    return j;
                }else{
                    nums[j] = nextElement;
                }
            }
        }
        return nums.length;
    }

    public int findMax(int num1, int num2){
        return (num1 > num2)? num1: num2;
    }

    public int findNext(int[] nums, int start, int element){
        for(int i=start; i<nums.length; i++){
            if(nums[i] > element){
                return nums[i];
            }
        }
        return element;
    }
}
