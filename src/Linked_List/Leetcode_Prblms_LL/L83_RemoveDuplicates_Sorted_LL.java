package Linked_List.Leetcode_Prblms_LL;




public class L83_RemoveDuplicates_Sorted_LL {
    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head = insertFirst(head,3);
        head = insertFirst(head,3);
        head = insertFirst(head,2);
        head = insertFirst(head,1);
        head = insertFirst(head,1);
        display(head);
        head = deleteDuplicates(head);
        display(head);



    }

    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    // Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
    // Return the linked list sorted as well.
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp!=null){
            temp.next = findNext(temp.next,temp.val);
            temp = temp.next;
        }
        return head;
    }

    public static ListNode findNext(ListNode node, int value){
        ListNode temp = node;
        while(temp != null){
            if(temp.val != value){
                return temp;
            }else{
                temp = temp.next;
            }
        }
        return temp;

    }

    public static ListNode insertFirst(ListNode head,int value){
        return new ListNode(value,head);
    }

    public static void display(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
