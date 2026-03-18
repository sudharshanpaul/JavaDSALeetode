package My_Trees.leetcode_problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class LevelOrderSuccessor {

    static void main(String[] args) {

    }

    public TreeNode successor(TreeNode root, int value) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        int ans = -1;
        if(root == null){
            return null;
        }
        queue.add(root);
        while(!queue.isEmpty()){

                TreeNode node = queue.pop();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(node.val == value){
                    return queue.getFirst();
                }

        }
        return null;
    }
}
