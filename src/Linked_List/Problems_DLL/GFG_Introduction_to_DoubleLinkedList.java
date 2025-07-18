package Linked_List.Problems_DLL;

public class GFG_Introduction_to_DoubleLinkedList {

    public static void main(String[] args) {

    }

    // https://www.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/1
    public Node constructDLL(int arr[]) {
        // Code here
        Node head = null;
        Node temp = null;
        for(int i=0; i<arr.length; i++){
            Node node = new Node(arr[i]);
            if(temp == null){
                head = node;
                temp = node;
            }else{
                node.prev = temp;
                temp.next = node;
                temp = node;
            }
        }
        return head;
    }
}
