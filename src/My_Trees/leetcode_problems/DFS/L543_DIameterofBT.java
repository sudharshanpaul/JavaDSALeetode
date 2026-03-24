package My_Trees.leetcode_problems.DFS;

public class L543_DIameterofBT {

    static void main(String[] args) {

    }

    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = -1;
        height(root);
        return ans;
    }

    public int height(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        ans = Math.max(ans, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;

    }
}
