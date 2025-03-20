package Linked_List.Leetcode_Prblms_LL.Reversal_LL;

import java.util.List;

public class L143_ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head = insertFirst(head,3);
        head = insertFirst(head,2);
        head = insertFirst(head,1);



    }

    // https://leetcode.com/problems/reorder-list/description/
    //You are given the head of a singly linked-list. The list can be represented as:
    //
    //L0 → L1 → … → Ln - 1 → Ln
    //Reorder the list to be on the following form:
    //
    //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    //You may not modify the values in the list's nodes. Only nodes themselves may be changed.

    // Let's do it in O(n) time complexity.... :)

    public static ListNode insertFirst(ListNode head, int value){
        return new ListNode(value,head);
    }

    public  void reorderList(ListNode head){
        if(head == null || head.next == null){
            return;
        }

        ListNode mid = findMid(head);
        ListNode sh = reverse(mid);
        ListNode fh = head;

        while(fh != null && sh != null){
            ListNode temp = fh.next;
            fh.next = sh;
            fh = temp;

            temp = sh.next;
            sh.next = fh;
            sh = temp;
        }

        if(fh != null){
            fh.next = null;
        }
    }

    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        while(fast != null && fast.next != null){
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        temp.next = null;
        return slow;
    }


    public void reorderList2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;
        if(head == null || head.next == null){
            return;
        }
        while(fast != null && fast.next != null){
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        temp.next = null;
        fast = reverse(slow);
        temp = head;
        slow = head.next;
        while(slow != null && fast != null){
            temp.next = fast;
            fast = fast.next;
            temp = temp.next;
            temp.next = slow;
            slow = slow.next;
            temp = temp.next;
        }

        if(fast != null){
            temp.next = fast;
        }

    }


    // This method takes O(n^2) time complexity
    public  void reorderList1(ListNode head) {
        ListNode tail = head;
        while(tail != null){
            tail.next = reverse(tail.next);
            tail = tail.next;
        }
    }

    public  ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        while(cur != null){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
