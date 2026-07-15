package My_Trees.leetcode_problems.DFS;

public class L426_ConvertBSTintoDoublyLinkedList {

    static void main(String[] args) {

    }

    static Node head;
    static Node tail;

    public static Node mainSolution(TreeNode root){
        if(root == null){
            return null;
        }
        helper(root);
        return head;
    }

    public static void helper(TreeNode node){
        if(node == null){
            return;
        }

        helper(node.left);

        Node newNode = new Node(node.val);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        helper(node.right);
    }

    public static Node mainBSTtoSouble(TreeNode root){
        head = null;
        convertBSTDoubleLL((root));
        return head;
    }

    public static Node convertBSTDoubleLL(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Left subtree
        Node leftTail = convertBSTDoubleLL(root.left);

        // Current node
        Node node = new Node(root.val);

        // Connect left tail with current node
        if (leftTail == null) {
            if (head == null) {
                head = node;
            }
        } else {
            leftTail.next = node;
            node.prev = leftTail;
        }

        // Right subtree
        Node rightTail = convertBSTDoubleLL(root.right);

        if (node.next == null && root.right != null) {
            // Find the head of the right list
            Node rightHead = rightTail;
            while (rightHead.prev != null) {
                rightHead = rightHead.prev;
            }

            node.next = rightHead;
            rightHead.prev = node;
        }

        // Return tail
        if (rightTail != null) {
            return rightTail;
        }

        return node;
    }
    static class Node{
        int value;
        Node prev;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
}
