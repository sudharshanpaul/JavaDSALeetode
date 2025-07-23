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

    public ListNode reverseList1(ListNode head) {
        // ListNode prev = null;
        // ListNode cur = head;
        // while(cur != null){
        //     ListNode next = cur.next;
        //     cur.next = prev;
        //     prev = cur;
        //     cur = next;
        // }
        // return prev;
        return helper(null, head);
    }
    public ListNode helper(ListNode prev, ListNode cur){
        if(cur == null){
            return prev;
        }
        ListNode ans;
        ListNode next = cur.next;
        cur.next = prev;
        ans = helper(cur, next);
        return ans;
    }
}
