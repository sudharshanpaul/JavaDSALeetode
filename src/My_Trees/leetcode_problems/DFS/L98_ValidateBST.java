package My_Trees.leetcode_problems.DFS;

public class L98_ValidateBST {

    static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }

        if(node.val <= min || node.val >= max){
            return false;
        }
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
