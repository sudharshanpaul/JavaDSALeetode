package My_Trees.My_Heaps;

public class Main {

    static void main(String[] args) {
        MyHeaps heap = new MyHeaps();
        heap.insert(10);
        heap.insert(20);
        heap.insert(50);
        heap.insert(6);
        heap.insert(3);

        System.out.println(heap.sort());

    }
}
