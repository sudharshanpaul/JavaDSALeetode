package Linked_List.Theory_LL.Double_LL;

public class DoubleLL_Main {

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(67);
        list.insertFirst(35);
        list.insertFirst(34);
        list.insertFirst(10);
        list.insertLast(77);
        list.insert(65,2);
        list.insertAferValue(10,67);
        list.insertAferValue(100,77);
        list.display();
        list.displayReverse();

    }
}
