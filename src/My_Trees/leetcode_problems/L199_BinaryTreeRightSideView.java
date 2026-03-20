package My_Trees.leetcode_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L199_BinaryTreeRightSideView {

    static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            result.add(queue.peek().val);
            for(int i=0; i<len; i++){
                TreeNode node = queue.poll();
                if(node.right != null) queue.offer(node.right);
                if(node.left != null) queue.offer(node.left);
            }
        }

        return result;
    }
}
