package My_Trees.leetcode_problems.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L637_AverageOfLevelsInBT {

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
