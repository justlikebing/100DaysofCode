// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Day84 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the root is null or matches either p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively search left and right subtrees for the LCA
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both left and right subtrees return non-null nodes, then the current root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If one of the subtrees is null, return the non-null subtree as the LCA
        return leftLCA != null ? leftLCA : rightLCA;
    }
}

