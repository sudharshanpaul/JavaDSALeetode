package My_Trees.leetcode_problems.DFS;

public class isPthExist {

    static void main(String[] args) {

    }

    public boolean isPathExist(TreeNode root, int[] nums){
        return helper(root, nums, 0);
    }
    public boolean helper(TreeNode node, int[] nums, int index){
        if(node == null){
            return false;
        }
        if(index >= nums.length || node.val != nums[index]){
            return false;
        }
        if(index == nums.length - 1 && node.left == null && node.right == null){
            return true;
        }
        return helper(node.left, nums, index+1) || helper(node.right, nums, index+1);
    }
}
