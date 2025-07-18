package Linked_List.Problems_DLL;

public class GFG_Double_LL_Insertiomn_at_Position {
    public static void main(String[] args) {

    }

    static Node addNode(Node head, int p, int x) {
        // Your code here
        Node temp = head;
        for(int i=0; i<p; i++){
            temp = temp.next;
        }
        Node node = new Node(x);
        node.prev = temp;
        node.next = temp.next;
        temp.next = node;

        return head;

    }
}
