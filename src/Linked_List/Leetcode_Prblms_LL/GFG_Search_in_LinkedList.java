package Linked_List.Leetcode_Prblms_LL;

public class GFG_Search_in_LinkedList {

    public static void main(String[] args) {

    }

    // https://www.geeksforgeeks.org/problems/search-in-linked-list-1664434326/1
    public static boolean searchKey(int n, Node head, int key) {
        // Code here
        while(head != null){
            if(head.data == key){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
