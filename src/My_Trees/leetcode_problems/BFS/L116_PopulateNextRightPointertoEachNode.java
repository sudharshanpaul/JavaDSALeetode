package My_Trees.leetcode_problems.BFS;

import My_Trees.leetcode_problems.Node;

import java.util.ArrayDeque;

public class L116_PopulateNextRightPointertoEachNode {

    static void main(String[] args) {

    }

    // Recursion -> Loop
     public Node connect(Node root){
         if(root == null) return null;

         Node leftMost = root;

         while(leftMost.left != null){
             Node currentNode = leftMost;
             while(currentNode != null){
                 currentNode.left.next = currentNode.right;
                 if(currentNode.next != null) currentNode.right.next = currentNode.next.left;
                 currentNode = currentNode.next;
             }
             leftMost = leftMost.left;
         }

         return root;
     }

     // Using Recursion
    public Node connect1(Node root){

        if(root == null || root.left == null){
            return root;
        }

        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        root.left = connect(root.left);
        root.right = connect(root.right);

        return root;

    }


    // Using Direct BFS approach
     public Node connect2(Node root) {
          ArrayDeque<Node> queue = new ArrayDeque<>();
          if(root == null) return null;

          queue.add(root);
          while(!queue.isEmpty()){
              int len = queue.size();
              for(int i=0; i<len; i++){
                  Node node = queue.pop();
                  if(node.right != null){
                      queue.add(node.left);
                      queue.add(node.right);
                  }
                  if(i != len - 1) node.next = queue.getFirst();

              }
          }

          return root;
     }
}
