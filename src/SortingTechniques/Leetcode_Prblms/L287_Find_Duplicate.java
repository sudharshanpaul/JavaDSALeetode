package SortingTechniques.Leetcode_Prblms;

public class L287_Find_Duplicate {
    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }

    // https://leetcode.com/problems/find-the-duplicate-number/description/

    public static int findDuplicate(int[] nums){
        int i=0;
        while(i<nums.length){
            if(nums[i]!=i+1){
                int correct = nums[i]-1;
                if(nums[i] != nums[correct]){
                    swap(nums,i,correct);
                }else{
                    return nums[i];
                }
            }else{
                i++;
            }
        }
        return -1;
    }


    public static int findDuplicate1(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums,i,correct);
            }else{
                if(i!=correct){
                    return nums[i];
                }
                i++;
            }
        }
        return -1;
    }

    public static void swap(int[] arr,int first,int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
