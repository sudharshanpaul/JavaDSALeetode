package Linked_List.Leetcode_Prblms_LL.Reversal_LL;

public class L25_ReverseNodes_K_Groups {

    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/reverse-nodes-in-k-group/
    //Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
    //
    //k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes
    // is not a multiple of k then left-out nodes, in the end, should remain as it is.
    //
    //You may not alter the values in the list's nodes, only nodes themselves may be changed.

    public ListNode reverseKGroup(ListNode head, int k) {
       if(head == null || head.next== null){
           return head;
       }
       ListNode ans = new ListNode();
       ListNode temp = new ListNode();
       boolean flag = true;
        while(true){
            ListNode start = head;
            int i;
            for (i = 0; i < k; i++) {
                if(head==null){
                    break;
                }
                head = head.next;
            }
            if(head==null && i!=k){
                temp.next = start;
                break;
            }
            temp.next = reverseK(start,head);
            if(flag){
                ans.next = temp.next;
                flag = false;
            }
            temp = start;
        }

        return ans.next;
    }

    public ListNode reverseK(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode cur = start;
        ListNode next = start;

        while(cur != end){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }


    // 2nd approach... Not the second approach but some what different

    public ListNode reverseKGroup2(ListNode head, int k){
        if(k<=1 && head==null){
            return head;
        }
        ListNode ans = new ListNode();
        while(true){
            ListNode start = head;
            for (int i = 0; i < k; i++) {
                head = head.next;
            }
        }
    }
}
