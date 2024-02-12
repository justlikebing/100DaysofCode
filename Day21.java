class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Day21 {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return diameter;
    }

    private int calculateDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = calculateDiameter(root.left);
        int rightHeight = calculateDiameter(root.right);

        // Update the diameter if a longer path is found
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Day21 treeDiameter = new Day21();

        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter of the binary tree: " + treeDiameter.diameterOfBinaryTree(root));
    }
}
