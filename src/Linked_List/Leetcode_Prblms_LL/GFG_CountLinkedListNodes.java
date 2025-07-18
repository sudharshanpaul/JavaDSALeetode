package Linked_List.Leetcode_Prblms_LL;

public class GFG_CountLinkedListNodes {

    public static void main(String[] args) {

    }

    // https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/1
    public static int getCount(Node head) {
        // code here
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}
