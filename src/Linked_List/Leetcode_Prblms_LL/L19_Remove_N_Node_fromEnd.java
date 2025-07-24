package Linked_List.Leetcode_Prblms_LL;

public class L19_Remove_N_Node_fromEnd {

    // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/");
    }

    // Given the head of a linked list, remove the nth node from the end of the list and return its head.

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode cur = head;
        int noMoves = findLength(head) - n;
        if(noMoves == 0){
            head = head.next;
            return head;
        }
        for(int i=0; i<noMoves; i++){
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }
    public int findLength(ListNode head){
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}
