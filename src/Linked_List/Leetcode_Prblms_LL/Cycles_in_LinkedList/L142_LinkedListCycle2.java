package Linked_List.Leetcode_Prblms_LL.Cycles_in_LinkedList;


public class L142_LinkedListCycle2 {

    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    //Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
    //
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
    //
    //Do not modify the linked list.

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length=0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = findLenCycle(slow);
                break;
            }
        }

        if (fast == null || fast.next == null) return null;

        ListNode f = head;
        ListNode s = head;

        for (int i = 0; i < length; i++) {
            s = s.next;
        }
        while(f == s){
            f = f.next;
            s = s.next;
        }

        return f;
    }


    public static int findLenCycle(ListNode head) {
        ListNode head1 = head;
        int length = 0;
        do{
            head1 = head1.next;
            length++;
        }while(head1 != head);

        return length;
    }

    // This will take O(n^2) time complexity
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode temp = head;
                while(true){
                    do{
                        if(temp == slow){
                            return temp;
                        }
                        slow = slow.next;
                    }while(slow != fast);
                    temp = temp.next;
                }
            }
        }

        return null;
    }
}
