package Linked_List.Leetcode_Prblms_LL;

public class L2095_DeleteMiddleNode_LL {

    // https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/");
    }

    // You are given the head of a linked list. Delete the middle node,
    // and return the head of the modified linked list.

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode cur = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }

    public ListNode deleteMiddle1(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        slow.next = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
