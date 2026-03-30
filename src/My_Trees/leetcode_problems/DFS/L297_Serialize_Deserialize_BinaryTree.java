package My_Trees.leetcode_problems.DFS;

public class L297_Serialize_Deserialize_BinaryTree {

    static void main(String[] args) {

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        if(root == null){
            return "N";
        }
        ans.append(root.val+",");
        ans.append(serialize(root.left));
        ans.append(serialize(root.right));
        return ans.toString();
    }

    int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.charAt(index) == 'N'){
            index++;
            return null;
        }

        StringBuilder str = new StringBuilder();
        while(data.charAt(index) != ','){
            str.append(data.charAt(index++));
        }
        index++;

        int num = Integer.parseInt(str.toString());


        TreeNode node = new TreeNode(num);
        node.left = deserialize(data);
        node.right = deserialize(data);

        return node;
    }
}
