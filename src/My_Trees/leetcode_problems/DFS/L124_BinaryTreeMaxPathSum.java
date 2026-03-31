package My_Trees.leetcode_problems.DFS;

public class L124_BinaryTreeMaxPathSum {

    static void main(String[] args) {

    }

    int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        helper(root);
        return ans;
    }

    public int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        if(left>0 && right>0){
            ans = Math.max(left + right + node.val, ans);
            return node.val + Math.max(left, right);
        }
        if(left < 0 && right < 0){
            ans = Math.max(node.val, ans);
            return node.val;
        }
        if(left > right){
            ans = Math.max(left + node.val, ans);
            return node.val + left;
        }else{
            ans = Math.max(right + node.val, ans);
            return node.val + right;
        }
    }

    int helperMain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubMax = Math.max(0, helperMain(root.left));
        int rightSubMax = Math.max(0, helperMain(root.right));
        ans = Math.max(ans, leftSubMax + rightSubMax + root.val);

        return Math.max(leftSubMax, rightSubMax) + root.val;
    }
}
