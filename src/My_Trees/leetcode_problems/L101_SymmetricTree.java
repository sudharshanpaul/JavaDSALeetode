package My_Trees.leetcode_problems;

import java.util.LinkedList;
import java.util.Queue;

public class L101_SymmetricTree {

    static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return true;
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if(first == null && second == null) continue;
            if(first == null || second == null) return false;
            if(first.val != second.val) return false;

            queue.offer(first.left);
            queue.offer(second.right);
            queue.offer(first.right);
            queue.offer(second.left);
        }

        return true;
    }
}
