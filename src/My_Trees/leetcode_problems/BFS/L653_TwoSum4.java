package My_Trees.leetcode_problems.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L653_TwoSum4 {

    static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {

    }

    public boolean helper(TreeNode node, Set<Integer> set, int required){
        if(node == null){
            return false;
        }
        if(set.contains(node.val)){
            return true;
        }
        int element = required - node.val;
        set.add(element);
        boolean left = helper(node.left, set, required);
        boolean right = helper(node.right, set, required);

        return left || right;
    }

    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return false;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                set.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        Set<Integer> dummy = new HashSet<>(set);

        for(Integer num:set){
            dummy.remove(num);
            if(dummy.contains(k - num)){
                return true;
            }
        }

        return false;

    }
}
