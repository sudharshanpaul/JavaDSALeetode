package Linked_List.Leetcode_Prblms_LL;

public class L61_RotateList {

    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/rotate-list/description/
    // Given the head of a linked list, rotate the list to the right by k places.

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }
        k = k % findLength(head);
        for (int i = 0; i < k; i++) {
            ListNode lastprev = null;
            ListNode last = head;
            while(last.next != null){
                lastprev = last;
                last = last.next;
            }
            last.next = head;
            head = last;
            lastprev.next = null;
        }

        return head;
    }

    public ListNode rotateRight1(ListNode head, int k){
        if(head == null || head.next == null || k==0){
            return head;
        }
        k = findLength(head) - (k % findLength(head));
        ListNode last = head;
        ListNode lastprev = null;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        for (int i = 0; i < k; i++) {
            lastprev = last;
            last = last.next;
        }
        lastprev.next = null;
        head = last;
        return head;
    }

    public int findLength(ListNode head){
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
}
