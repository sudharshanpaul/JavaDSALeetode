package Linked_List.Leetcode_Prblms_LL.Reversal_LL;

public class L92_ReverseLinkedList2 {

    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/reverse-linked-list-ii/
    //Given the head of a singly linked list and two integers left and right where left <= right,
    // reverse the nodes of the list from position left to position right, and return the reversed list.
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = head;
        ListNode cur = head;
        ListNode next = head;
        ListNode first = null;
        for (int i = 0; i < right; i++) {
            prev = prev.next;
        }
        for (int i = 1; i <= left-1; i++) {
            first = (first == null)? head: first.next;
        }
        for (int i = 1; i < left; i++) {
            cur = cur.next;
            next = next.next;
        }

        while(right != left){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            right--;
        }
        if(first == null){
            return prev;
        }
        first.next = prev;
        return head;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right){
        if(left == right){
            return head;
        }

        // skip the first left - 1 nodes

        ListNode current = head;
        ListNode prev = null;

        for (int i = 0;current != null && i < left - 2; i++) {
            prev = current;
            current = current.next;
        }

        ListNode last = prev;
        ListNode newEnd = current;

        // Reverse between left and right
        ListNode next = current.next;
        for (int i = 0; current!=null && i < right-left+1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }
        newEnd.next = current;
        return head;
    }
}
