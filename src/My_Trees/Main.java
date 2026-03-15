package My_Trees;

import java.util.Scanner;

public class Main {
    static void main() {

        Scanner scanner = new Scanner(System.in);
//        BinaryTrees tree = new BinaryTrees();
//        tree.populate(scanner);
//        tree.display();

        BST bst = new BST();
        int[] nums = {5,2,7,1,4,6,9,8,3,10};
        bst.populate(nums);
        bst.display();
        System.out.println(bst.balanced());

    }
}
