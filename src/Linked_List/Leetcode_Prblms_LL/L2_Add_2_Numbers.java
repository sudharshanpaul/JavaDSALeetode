package Linked_List.Leetcode_Prblms_LL;

import java.util.Scanner;

public class L2_Add_2_Numbers {

    public static void main(String[] args) {
        ListNode1 list1 = createLinkedList();
        ListNode1 list2 = createLinkedList();
    }

    public static ListNode1 createLinkedList(){
        ListNode1 head = null;
        ListNode1 temp = null;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter a value:");
            int value = scanner.nextInt();
            ListNode1 node = new ListNode1(value);
            if(head==null){
                head = node;
                temp = node;
            }else{
                temp.next = node;
            }
            temp = temp.next;
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            ListNode node = new ListNode(0);
            return node;
        }
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode ans = null;
        ListNode temp = null;
        while(l1 != null || l2 != null || carry>0){
            int sum;
            if(l1 != null && l2 != null){
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else if (l2 != null) {
                sum = l2.val + carry;
                l2 = l2.next;
            }else{
                sum = carry;
            }
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            if(temp==null){
                ans = temp = node;
            }else{
                temp.next = node;
                temp = temp.next;
            }
        }
        return ans;
    }

    public static class ListNode1 {
        int val;
        ListNode1 next;
        ListNode1() {};
        ListNode1(int val) { this.val = val; }
        ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }

    }
}


