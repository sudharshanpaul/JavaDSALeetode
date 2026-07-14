package My_Trees.leetcode_problems.DFS;

import java.util.HashSet;
import java.util.Set;

public class L653_TwoSum4 {

    static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        return helper(root, new HashSet<Integer>(), k);
    }

    public boolean helper(TreeNode node, Set<Integer> set, int required){
        if(node == null) return false;
        if(set.contains(node.val)) return true;

        set.add(required - node.val);

        return helper(node.left, set, required) || helper(node.right, set, required);
    }
}
