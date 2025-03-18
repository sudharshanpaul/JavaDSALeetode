package Linked_List.Leetcode_Prblms_LL;

public class L21_MergeTwoSortedLL {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(4);
        list1 = insertFirst(list1,2);
        list1 = insertFirst(list1,1);

        ListNode list2 = new ListNode(4);
        list2 = insertFirst(list2,3);
        list2 = insertFirst(list2,1);

        display(list1);
        display(list2);

        ListNode head = mergeTwoLists(list1,list2);
        display(head);


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


    // https://leetcode.com/problems/merge-two-sorted-lists/description/

    // You are given the heads of two sorted linked lists list1 and list2.

    //Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

    //Return the head of the merged linked list.

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode node,head;
        if(list1.val < list2.val){
            head = node = list1;
            list1 = list1.next;
        }else{
            head = node = list2;
            list2 = list2.next;
        }

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            }else{
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }
        while(list1 != null){
            node.next = list1;
            node = node.next;
            list1 = list1.next;
        }
        while(list2 != null){
            node.next = list2;
            node = node.next;
            list2 = list2.next;
        }

        return head;
    }

}
