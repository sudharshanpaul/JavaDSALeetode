package Linked_List.Leetcode_Prblms_LL;

public class L328_OddEvenLinkedList {

    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        int i = 0;
        ListNode temp = head;
        ListNode odd = null;
        ListNode even = null;
        ListNode evenHead = null;
        while(temp != null){
            if(i%2 == 0){
                if(odd == null){
                    odd = temp;
                }else{
                    odd.next = temp;
                    odd = odd.next;
                }
            }else{
                if(even == null){
                    evenHead = temp;
                    even = temp;
                }else{
                    even.next = temp;
                    even = even.next;
                }
            }
            temp = temp.next;
            i++;
        }
        odd.next = evenHead;
        even.next = null;
        return head;
    }
}
