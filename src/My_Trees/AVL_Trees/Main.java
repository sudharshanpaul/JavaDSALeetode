package My_Trees.AVL_Trees;

public class Main {

    static void main(String[] args) {
        AVL tree = new AVL();
        for (int i = 0; i < 1000; i++) {
            tree.insert(i);
        }

        System.out.println(tree.height());
    }
}
