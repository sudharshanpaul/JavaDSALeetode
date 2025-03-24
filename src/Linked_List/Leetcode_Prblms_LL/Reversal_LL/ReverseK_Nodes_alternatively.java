package Linked_List.Leetcode_Prblms_LL.Reversal_LL;

public class ReverseK_Nodes_alternatively {

    public static void main(String[] args) {

    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        boolean reverse = true;

        while (head != null) {
            ListNode start = head;
            ListNode end = head;
            int count = 0;


            while (end != null && count < k) {
                end = end.next;
                count++;
            }

            if (count < k) {
                prevGroupEnd.next = start;
                break;
            }

            if (reverse) {
                prevGroupEnd.next = reverseK(start, end);
                prevGroupEnd = start;
            } else {
                prevGroupEnd.next = start;
                prevGroupEnd = end == null ? start : head;
            }

            head = end;
            reverse = !reverse;
        }

        return dummy.next;
    }

    public static ListNode reverseK(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode cur = start;

        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev; 
    }
}
