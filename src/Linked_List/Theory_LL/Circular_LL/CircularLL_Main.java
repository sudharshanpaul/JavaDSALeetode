package Linked_List.Theory_LL.Circular_LL;

public class CircularLL_Main {

    public static void main(String[] args) {
        CLL list = new CLL();
        list.insertFirst(10);
        list.insertLast(100);
        list.insert(23,1);
        list.insertLast(179);
        list.insertFirst(777);
        list.deleteFirst();
        list.deleteLast();
        list.display();
    }
}
