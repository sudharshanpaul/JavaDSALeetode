package Linked_List.Leetcode_Prblms_LL;

public class GFG_Find_Length_of_Loop {

    public static void main(String[] args) {

    }
    // https://www.geeksforgeeks.org/problems/find-length-of-loop/1
    public int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int lenCircle = 0;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                do{
                    fast = fast.next;
                    lenCircle++;
                }while(slow != fast);
                return lenCircle;
            }
        }
        return lenCircle;
    }
}
