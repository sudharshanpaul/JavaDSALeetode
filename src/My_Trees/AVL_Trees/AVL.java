package My_Trees.AVL_Trees;

public class AVL {

    private Node root;

    private static class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){
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

    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node == null) return -1;
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root node value: ");
    }
    private void display(Node node, String details){

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
    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value < node.value){
            node.left = insert(value, node.left);
        }
        if(value > node.value){
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return rotate(node);
    }

    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            // left heavy
            if(height(node.left.left)>height(node.left.right)){
                //left left case
                return rightRotate(node);
            }
            if(height(node.left.left)<height(node.left.right)){
                // left - right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left) - height(node.right) < -1){
            // right heavy
            if(height(node.right.left)<height(node.right.right)){
                //right - right case
                return leftRotate(node);
            }
            if(height(node.right.left)>height(node.right.right)){
                // right - left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;

        return c;
    }

    private Node leftRotate(Node c){
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        c.height = Math.max(height(c.left), height(c.right))+1;
        p.height = Math.max(height(p.left), height(p.right))+1;


        return p;
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
    private boolean balanced(Node node){
        if(node == null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

}

