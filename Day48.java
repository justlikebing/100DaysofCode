import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Day48 {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        // Perform a level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        queue.offer(root);
        colQueue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int col = colQueue.poll();

                if (!map.containsKey(col)) {
                    map.put(col, new TreeMap<>());
                }

                if (!map.get(col).containsKey(node.val)) {
                    map.get(col).put(node.val, new ArrayList<>());
                }

                map.get(col).get(node.val).add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                    colQueue.offer(col - 1);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                    colQueue.offer(col + 1);
                }
            }
        }

        // Extract values from TreeMap
        for (int col : map.keySet()) {
            List<Integer> level = new ArrayList<>();

            for (int val : map.get(col).keySet()) {
                level.addAll(map.get(col).get(val));
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        VerticalOrderTraversal solution = new VerticalOrderTraversal();
        List<List<Integer>> result = solution.verticalTraversal(root);

        System.out.println(result);
    }
}
