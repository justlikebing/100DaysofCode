class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Day15 {

    private int maxSum = Integer.MIN_VALUE;

    private int findMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(findMaxPathSum(root.left), 0);
        int rightMax = Math.max(findMaxPathSum(root.right), 0);

        maxSum = Math.max(maxSum, leftMax + rightMax + root.val);
        return Math.max(leftMax, rightMax) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        Day15 maxPathSumFinder = new Day15();
        int result = maxPathSumFinder.maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result);
    }
}
