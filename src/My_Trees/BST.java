package My_Trees;

public class BST {

    private BSTNode root;

    private static class BSTNode{
        private int value;
        private BSTNode left;
        private BSTNode right;
        private int height;

        public BSTNode(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

        public void setHeight(int height){
            this.height = height;
        }
    }



//    public int height(BSTNode node){
//        if(node == null) return 0;
//        int leftHeight = 0;
//        int rightHeight = 0;
//
//        leftHeight += height(node.left) + 1;
//        rightHeight += height(node.right) + 1;
//
//        return Math.max(leftHeight, rightHeight);
//    }

    public int height(BSTNode node){
        if(node == null) return -1;
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root node value: ");
    }
    private void display(BSTNode node, String details){

        if(node == null) return;

        System.out.println(details + node.getValue());

        display(node.left, "Left child of "+ node.getValue()+":");
        display(node.right, "Right child of "+ node.getValue()+":");

    }

//    public void insert(int value){
//        if(root == null){
//            root = new BSTNode(value);
//        }else{
//            insert(root, value);
//        }
//    }
//
//
//    public void insert(BSTNode node, int value){
//        if(value < node.value && node.left == null){
//            BSTNode n = new BSTNode(value);
//            node.left = n;
//            return;
//
//        }else if(value >= node.value && node.right == null){
//            BSTNode n = new BSTNode(value);
//            node.right = n;
//            return;
//        }
//        if(value < node.value){
//            insert(node.left, value);
//        }else{
//            insert(node.right, value);
//        }
//    }

    public void insert(int value){
        root = insert(value, root);
    }
    private BSTNode insert(int value, BSTNode node){
        if(node == null){
            node = new BSTNode(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }
        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return node;
    }

    public void populate(int[] nums){
        for(int num: nums){
            insert(num);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }
    public void populateSorted(int[] nums,int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end-start)/2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid+1, end);
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(BSTNode node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

}
