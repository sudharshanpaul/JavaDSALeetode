package My_Trees.leetcode_problems.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class L993_CousinsInBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = find(root, x);
        TreeNode yy = find(root, y);

        return  (
                (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
    }


    public boolean isSibling(TreeNode root, TreeNode first, TreeNode second){
        if(root == null) return false;

        return (
                (root.left == first && root.right == second) || (root.left == second && root.right == first) || isSibling(root.left, first, second) || isSibling(root.right, first, second)
        );
    }

    public int level(TreeNode root, TreeNode node, int level){
        int ans = -1;
        if(root == null) return -1;
        if(root == node) return level;

        ans = level(root.left, node, level+1);
        ans = (ans == -1)? level(root.right, node, level+1): ans;

        return ans;

    }

    public TreeNode find(TreeNode root, int val){
        TreeNode node;

        if(root == null) return root;
        if(root.val == val) return root;

        node = find(root.left, val);
        node = (node == null)? find(root.right, val): node;

        return node;
    }

    public boolean isCousins1(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return false;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            boolean first = false;
            boolean second = false;
            boolean sameParentLeft = false;
            boolean sameParentRight = false;
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode node = queue.poll();
                if(node.left != null){

                    if(node.left.val == x){
                        first = true;
                        sameParentLeft = true;
                    }
                    if(node.left.val == y){
                        second = true;
                        sameParentLeft = true;
                    }

                    queue.offer(node.left);
                }
                if(node.right != null){
                    if(node.right.val == x){
                        first = true;
                        sameParentRight = true;
                    }
                    if(node.right.val == y){
                        second = true;
                        sameParentRight = true;
                    }
                    queue.offer(node.right);
                }
                if(first && second){
                    if(sameParentLeft && sameParentRight) return false;
                    return true;
                }
                sameParentLeft = false;
                sameParentRight = false;
            }

        }

        return false;
    }
}
