package Linked_List.Leetcode_Prblms_LL;

public class GFG_LinkedListInsertion_at_End {

    public static void main(String[] args) {

    }

    public static Node insertAtEnd(Node head, int x) {
        if(head == null){
            Node node = new Node(x);
            head = node;
            return head;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        Node node = new Node(x);
        temp.next = node;
        return head;
    }
}
