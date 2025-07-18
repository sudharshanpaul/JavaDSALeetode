package Linked_List.Problems_DLL;

public class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
    }
    Node(int data, Node prev){
        this.data = data;
        this.prev = prev;
    }
}
