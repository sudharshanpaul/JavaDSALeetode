package My_Trees.leetcode_problems.DFS;

import java.util.HashMap;

public class L105_ConstructBinaryTree_Preorder_inorder {

    static void main(String[] args) {

    }

    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(preorder, map, 0, preorder.length-1);
    }


    public TreeNode helper(int[] preorder, HashMap<Integer, Integer> map, int low, int high){
        if(low > high){
            return null;
        }

        TreeNode node = new TreeNode(preorder[index++]);
        node.left = helper(preorder, map, low, map.get(node.val)-1);
        node.right = helper(preorder, map, map.get(node.val)+1, high);

        return node;
    }
}
