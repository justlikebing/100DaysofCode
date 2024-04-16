import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Day82 {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val).append(" ");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("-1 ");
            }
        }
        return sb.toString().trim();
    }
    
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals("-1")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (!values[++i].equals("-1")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
    
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
    
    public static void main(String[] args) {
        BinaryTreeSerialization bt = new BinaryTreeSerialization();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        
        String serializedTree = bt.serialize(root);
        System.out.println("Serialized tree: " + serializedTree);
        
        TreeNode deserializedRoot = bt.deserialize(serializedTree);
        
        // Print inorder traversal of deserialized binary tree
        System.out.print("Inorder traversal of deserialized tree: ");
        bt.inorderTraversal(deserializedRoot);
    }
}
