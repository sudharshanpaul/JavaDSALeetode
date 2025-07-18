package Linked_List.Leetcode_Prblms_LL;

public class GFG_Array_to_LinkedList {

    public static void main(String[] args) {

    }

    public static Node constructLL(int arr[]) {
        Node head = null;
        Node temp = null;
        for (int i = 0; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            if(temp == null){
                head = node;
                temp = node;
            }else{
                temp.next = node;
                temp = temp.next;
            }
        }
        return head;
    }
}
