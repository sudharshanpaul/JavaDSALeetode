package My_Trees.leetcode_problems.DFS;

public class L129_SumRoot_to_Leaf {

    static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return helper(root, 0);
    }

    public int helper(TreeNode node, int sum){
        int ans = 0;
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null){
            return sum;
        }
        if(node.left != null){
            ans += helper(node.left, sum);
        }
        if(node.right != null){
            ans += helper(node.right, sum);
        }

        return ans;
    }
}
