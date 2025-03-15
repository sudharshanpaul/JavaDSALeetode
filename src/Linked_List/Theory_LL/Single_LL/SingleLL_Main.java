package Linked_List.Theory_LL.Single_LL;

public class SingleLL_Main {

    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertLast(7);
        list.insert(77,2);
        list.insert(56,4);
        list.display();
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();
        list.insertUsingRecursion(1,3);
        list.display();
        list.insertRec(88,2);
        list.display();
    }
}
