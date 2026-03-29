package My_Trees.leetcode_problems.DFS;

import java.util.Queue;

public class L230_KSmallest_in_BST {

    static void main(String[] args) {

    }

    int ans;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        // ans = -1;
        // helper(root, 0, k);
        // return ans;

        return helperMain(root, k).val;

        // Queue<Integer> queue = new LinkedList<>();
        // inOrderTraversal(root, queue);
        // for(int i=0; i<k; i++){
        //     if(i == k-1){
        //         return queue.poll();
        //     }
        //     queue.poll();
        // }
        // return -1;
    }

    // Approach where do the in-order traversal and return the Kth node
    public void inOrderTraversal(TreeNode node, Queue<Integer> queue){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left, queue);
        queue.offer(node.val);
        inOrderTraversal(node.right, queue);
    }

    public TreeNode helperMain(TreeNode node, int k){
        if(node == null){
            return null;
        }

        TreeNode left = helperMain(node.left, k);
        count++;
        if(left != null) return left;
        if(count == k) return node;
        return helperMain(node.right, k);
    }



    public int helper(TreeNode node, int index, int k){
        if(node == null){
            return index;
        }

        int left = helper(node.left, index, k);
        index = left + 1;
        if(index == k && ans == -1){
            ans = node.val;
        }
        int right = helper(node.right, index, k);
        if(right == k && ans == -1){
            ans = node.val;
        }

        return right;

    }
}
