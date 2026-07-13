package My_Trees.leetcode_problems.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L314_BinaryTreeVerticalOrderTraversal {

    HashMap<Integer, List<Integer>> map;
    int min;
    int max;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        min  = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, 0);

        for(int i=min; i<=max; i++){
            ans.add(map.get(i));
        }

        return ans;
    }
    public void helper(TreeNode node, int row, int col){
        if(node == null){
            return;
        }
        if(map.containsKey(col)){
            boolean flag = true;
            for(int i=0; i<map.get(col).size(); i++){
                if(map.get(col).get(i) > node.val){
                    map.get(col).add(i, node.val);
                    flag = false;
                    break;
                }
            }
            if(flag){
                map.get(col).add(node.val);
            }
        }else{
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(col, list);
            min = Math.min(min, col);
            max = Math.max(max, col);
        }

        helper(node.left, row+1, col - 1);
        helper(node.right, row+1, col + 1);
    }
}
