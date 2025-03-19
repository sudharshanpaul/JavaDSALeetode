package Linked_List.Leetcode_Prblms_LL.Reversal_LL;

import java.util.List;

public class L234_PalindromeLinkedList {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head){
        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reverseHead = headSecond;


        // Compare
        while( head != null && headSecond != null){
            if(head.val != headSecond.val){
                return false;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        reverseList(mid);
        return true;
    }

    public ListNode reverseList(ListNode head){
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
    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
    public boolean isPalindrome1(ListNode head) {
        ListNode last = null;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        int mid = findMid(head);

        if(mid == 0){
            return true;
        }

        for (int i = 0; i < mid; i++) {
            last = cur;
            cur = cur.next;
            next = next.next;
        }

        while(next != null){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        last.next = prev;

        ListNode temp = head;
        while(temp != last.next){
            if(temp.val != prev.val){
                return false;
            }
            temp = temp.next;
            prev = prev.next;
        }

        return true;
    }

    public int findMid(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }

        return count/2;
    }

}
