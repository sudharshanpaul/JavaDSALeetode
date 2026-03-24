package My_Trees.leetcode_problems.BFS;

import java.util.*;

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

    public static class L637_AverageOfLevelsinBinaryTree {

        static void main(String[] args) {

        }

        public List<Double> averageOfLevels(TreeNode root) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            List<Double> list = new ArrayList<>();
            if(root == null){
                return list;
            }
            queue.add(root);
            while(!queue.isEmpty()){
                double sum = 0;
                int length = queue.size();
                for(int i=0; i<length; i++){
                    TreeNode node = queue.pop();
                    sum += node.val;
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                list.add(sum / length);
            }
            return list;
        }
    }
}
