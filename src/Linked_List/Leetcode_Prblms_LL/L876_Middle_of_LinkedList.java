package Linked_List.Leetcode_Prblms_LL;

import java.util.List;

public class L876_Middle_of_LinkedList {

    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        int mid = findMidLength(head);
        for (int i = 0; i < mid; i++) {
            head = head.next;
        }
        return head;
    }

    public int findMidLength(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count/2;
    }
}
