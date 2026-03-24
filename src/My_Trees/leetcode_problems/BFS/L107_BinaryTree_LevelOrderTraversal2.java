package My_Trees.leetcode_problems.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L107_BinaryTree_LevelOrderTraversal2 {

    static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        queue.add(root);

        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> innerList = new ArrayList<>(len);
            for(int i=0; i<len; i++){
                TreeNode node = queue.pop();
                innerList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(0, innerList);
        }

        return result;
    }
}
