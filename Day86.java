class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Day86 {
    public boolean checkSumProperty(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        return isSumPropertyValid(root);
    }
    
    private boolean isSumPropertyValid(TreeNode node) {
        if (node == null) {
            return true;
        }
        
        if (node.left == null && node.right == null) {
            return true;
        }
        
        int sum = 0;
        if (node.left != null) {
            sum += node.left.val;
        }
        if (node.right != null) {
            sum += node.right.val;
        }
        
        return (node.val == sum) && isSumPropertyValid(node.left) && isSumPropertyValid(node.right);
    }
}
