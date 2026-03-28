package My_Trees.leetcode_problems.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class L114_FlattenBinaryTree {

    static void main(String[] args) {

    }


    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode current = root;
        TreeNode right = current.right;
        current.right = current.left;
        current.left = null;
        flatten(current.right);
        while(current.right != null){
            current = current.right;
        }
        current.right = right;
        flatten(current.right);
    }

    public void flatten1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        helper(root, queue);
        root = queue.poll();
        TreeNode temp = root;
        while(!queue.isEmpty()){
            temp.left = null;
            temp.right = queue.poll();
            temp = temp.right;
        }
    }
    public void helper(TreeNode node, Queue<TreeNode> queue){
        if(node == null) return;
        queue.offer(node);
        helper(node.left, queue);
        helper(node.right, queue);
    }
}
