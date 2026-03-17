package My_Trees.Segment_Trees;

public class Segment_Tree {

    private static Node root;

    private class Node{
        int value;
        int startIndex;
        int endIndex;

        Node left;
        Node right;

        public Node(int startIndex, int endIndex){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public Segment_Tree(int[] arr){
        this.root = constructTree(arr, 0, arr.length-1);
    }

    // constructing the tree
    private Node constructTree(int[] arr, int start, int end){
        if(start == end){
            // Leaf node
            Node leaf = new Node(start, end);
            leaf.value = arr[start];
            return leaf;
        }

        //  Creating a node in which we are at
        Node node = new Node(start, end);
        int mid = start + (end-start)/2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid+1, end);

        node.value = node.left.value + node.right.value;

        return node;

    }

    public int query(int start, int end){
        return  query(root, start, end);
    }
    private int query(Node node, int start, int end){
        if(node.startIndex >= start && node.endIndex<=end){
            // node is completely lying inside query
            return node.value;
        }
        if(node.startIndex > end || node.endIndex < start){
            // completely outside
            return 0;
        }

        return query(node.left, start, end) + query(node.right, start, end);

    }

    public void update(int value, int index){
        root.value = update(root, value, index);
    }

    private int update(Node node, int value, int index){
        if(node.startIndex == index && node.endIndex == index){
            node.value = value;
            return value;
        }
        if(node.startIndex > index || node.endIndex < index){
            return node.value;
        }

        node.value = update(node.left, value, index) + update(node.right, value, index);

        return node.value;
    }
}
