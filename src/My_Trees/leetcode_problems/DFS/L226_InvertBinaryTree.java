package My_Trees.leetcode_problems.DFS;

public class L226_InvertBinaryTree {

    static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
