package My_Trees.leetcode_problems.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L103_BinaryTreeZigZagBFS {

    static void main(String[] args) {

    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        boolean check = true;
        if(root == null){
            return list;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> innerList = new ArrayList<>();
            int length = queue.size();
            for(int i=0; i<length; i++){
                if(check){
                    TreeNode node = queue.pop();
                    innerList.add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }else{
                    TreeNode node = queue.removeLast();
                    innerList.add(node.val);
                    if(node.right != null) queue.addFirst(node.right);
                    if(node.left != null) queue.addFirst(node.left);
                }
            }
            list.add(innerList);
            check = !check;
        }
        return list;
    }


    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        boolean check = true;
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

            if(check) list.add(innerList);
            else list.add(innerList.reversed());
            check = !check;
        }
        return list;
    }
}
