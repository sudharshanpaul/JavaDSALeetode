package Linked_List.Leetcode_Prblms_LL;

public class L237_Delete_Node_in_LinkedList {
    public static void main(String[] args) {

    }
    public static void deleteNode(ListNode node) {
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;

    }
}
