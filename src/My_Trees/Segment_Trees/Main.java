package My_Trees.Segment_Trees;

public class Main {
    static void main(String[] args) {
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        Segment_Tree tree = new Segment_Tree(arr);

//        tree.update(14, 3);

        System.out.println(tree.query(1, 6));
    }
}
