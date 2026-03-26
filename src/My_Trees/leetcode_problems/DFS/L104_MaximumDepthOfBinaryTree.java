package My_Trees.leetcode_problems.DFS;

public class L104_MaximumDepthOfBinaryTree {

    static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int leftHt = maxDepth(root.left);
        int rightHt = maxDepth(root.right);

        return Math.max(leftHt, rightHt) + 1;
    }
}
