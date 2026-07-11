package My_Trees.leetcode_problems.DFS;

public class noOfPathSumExist {

    static void main(String[] args) {

    }
    int ans;
    public int noOfPaths(TreeNode root, int sum){
        ans = 0;
        helper(root, sum, 0);
        return ans;
    }

    public void helper(TreeNode node, int sum, int curSum){
        if(node == null){
            return;
        }
        if(node.val + curSum == sum){
            ans++;
        }
        helper(node.left, sum, curSum);
        helper(node.left, sum, curSum + node.val);
        helper(node.right, sum, curSum);
        helper(node.right, sum, curSum + node.val);
    }
}
