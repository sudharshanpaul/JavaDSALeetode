package Linked_List.Soting_LL;

import java.util.List;

public class L148_SortList {

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head = insertFirst(head,1);
        head = insertFirst(head,2);
        head = insertFirst(head,4);
        head = sortList(head);
        display(head);

    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left,right);

    }
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode midPrev = head;

        while(fast!= null && fast.next != null){
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        midPrev.next = null;
        return slow;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(list1 != null && list2 !=null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        tail.next = (list1 == null)? list2: list1;
        return dummyHead.next;
    }

    // This is a bubble sorting technique which takes O(n^2) time complexity
    public static ListNode sortList1(ListNode head) {
        int len = lenOfList(head);
        for(int i=0;i<len;i++){
            boolean  check = true;
            ListNode temp = head;
            for(int j=1; j<len-i;j++){
                if(temp.val > temp.next.val){
                    swap(temp,temp.next);
                    check = false;
                }
                temp = temp.next;
            }
            if(check){
                return head;
            }
        }
        return head;
    }
    public static void swap(ListNode first, ListNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    public static void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public static int lenOfList(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static ListNode insertFirst(ListNode head, int value){
        return new ListNode(value,head);
    }
}
