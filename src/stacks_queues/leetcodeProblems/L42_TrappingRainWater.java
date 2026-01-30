package stacks_queues.leetcodeProblems;

public class L42_TrappingRainWater {

    public static void main(String[] args) {

    }


    //Optimal One

    public int trap(int[] height) {
        int total = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length -1;

        while(left < right){
            if(height[left] <= height[right]){
                if(leftMax > height[left]){
                    total += leftMax - height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            }else{
                if(rightMax > height[right]){
                    total += rightMax - height[right];
                }else{
                    rightMax = height[right];
                }
                right--;
            }
        }

        return total;
    }
    public int trap1(int[] height) {
        int ans = 0;
        int[] nextGreatest = findRightMax(height);
        int[] prevGreatest = findLeftMax(height);

        for(int i=0; i<height.length; i++){
            if(nextGreatest[i]>height[i] && prevGreatest[i]>height[i]){
                ans += Math.min(nextGreatest[i], prevGreatest[i]) - height[i];
            }
        }
        return ans;
    }

    public int[] findRightMax(int[] arr){
        int[] ans = new int[arr.length];
        int rightMax = 0;
        for(int i=arr.length-1; i>=0; i--){
            ans[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }
        return ans;
    }

    public int[] findLeftMax(int[] arr){
        int[] ans = new int[arr.length];
        int leftMax = 0;
        for(int i=0; i<arr.length; i++){
            ans[i] = leftMax;
            leftMax = Math.max(leftMax, arr[i]);
        }
        return ans;
    }


}
