import java.util.LinkedList;
import java.util.Queue;
class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
public class BinaryTreeWidth {

    public int maxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int leftmostIndex = -1; // Initialize leftmost index for the current level
            int rightmostIndex = -1; // Initialize rightmost index for the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (current != null) {
                    if (leftmostIndex == -1) {
                        leftmostIndex = i; // Update leftmost index for the current level
                    }

                    rightmostIndex = i; // Update rightmost index for the current level

                    queue.offer(current.left);
                    queue.offer(current.right);
                } else {
                    queue.offer(null);
                    queue.offer(null);
                }
            }

            if (leftmostIndex != -1) {
                int currentWidth = rightmostIndex - leftmostIndex + 1;
                maxWidth = Math.max(maxWidth, currentWidth);
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        BinaryTreeWidth solution = new BinaryTreeWidth();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int maxWidth = solution.maxWidth(root);
        System.out.println("Maximum Width: " + maxWidth); // Output: 2
    }
}
