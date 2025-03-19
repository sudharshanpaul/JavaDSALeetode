package Linked_List.Leetcode_Prblms_LL;

public class L234_PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head = insertFirst(head,2);
        head = insertFirst(head,2);
        head = insertFirst(head,1);

        System.out.println(isPalindrome(head));

    }
    public static ListNode insertFirst(ListNode head,int value){
        return new ListNode(value,head);
    }

    // This functions works well but the range of the number is not enough
    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        long num = 0;
        while(temp != null){
            num *= 10;
            num += temp.val;
            temp = temp.next;
        }
        long revNum = 0;
        long dummy = num;
        while(num != 0){
            revNum *= 10;
            revNum += (num%10);
            num /= 10;
        }
        return dummy == revNum;
    }
}
