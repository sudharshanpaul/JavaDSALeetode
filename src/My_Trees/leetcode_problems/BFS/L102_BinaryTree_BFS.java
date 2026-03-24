package My_Trees.leetcode_problems.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L102_BinaryTree_BFS {

    static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> innerList = new ArrayList<>();
            int length = queue.size();
            for(int i=0; i<length; i++){
                TreeNode node = queue.pop();
                innerList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            list.add(innerList);
        }
        return list;
    }
}
