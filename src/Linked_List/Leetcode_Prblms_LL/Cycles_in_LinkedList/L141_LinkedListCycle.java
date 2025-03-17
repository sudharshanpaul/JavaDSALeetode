package Linked_List.Leetcode_Prblms_LL.Cycles_in_LinkedList;


public class L141_LinkedListCycle {

    public static void main(String[] args) {


    }

    // https://leetcode.com/problems/linked-list-cycle/
    // Given head, the head of a linked list, determine if the linked list has a cycle in it.
    //
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
    //
    //Return true if there is a cycle in the linked list. Otherwise, return false.

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    // Finding the length of the Cycle
    public static int findLenCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                int count = 0;
                do{
                    slow = slow.next;
                    count++;
                }while(fast != slow);
                return count;
            }
        }

        return 0;
    }
}
