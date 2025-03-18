package Linked_List.Leetcode_Prblms_LL.Reversal_LL;

import Linked_List.Theory_LL.Single_LL.LL;

public class L206_ReverseLinkedList {

    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        while(next != null){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        return head;
    }
}
