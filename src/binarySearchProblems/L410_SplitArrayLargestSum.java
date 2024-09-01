package binarySearchProblems;

public class L410_SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        System.out.println(splitArray(arr,2));
    }

    public static int splitArray(int[] nums, int k) {
//        int start = findMin(nums);
//        int end = findMax(nums);
        int start=0,end=0;
        for(int i:nums){
            start = Math.max(start,i);
            end+=i;
        }



        // [start,end] this is the possible range of answers for all the splitting cases
        while(start != end){
            int mid = start + (end-start)/2;   // Here my mid value is the possible max sum of that array that we required
            int splitCount = noSplits(nums,mid);
            if(splitCount<=k){         // If we are splitting minimum no of times means the array sum  can be less so we want to check in [start,mid]
                end = mid;
            }else{      // Here we are splitting the array into more no of times ,means the sum of that split array is less than the actual sum
                start = mid+1;
            }
        }

        return start;
    }

    // Minimum of the range is ..., WE can split the array into max parts is splitting each element
    // So max of that elements is the max answer of this case
    public static int findMin(int[] nums){
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }

    // It is the max of the range because we can split the array minimally is retaining the same array as it it
    // So the max sum is tht total sum of that array
    public static int findMax(int[] nums){
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        return sum;
    }

    public static int noSplits(int[] nums,int maxSum){
        int ans = 1;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>maxSum){
                ans++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }

        }

        return ans;
    }
}
