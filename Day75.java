import java.util.*;

public class Day75 {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // Colors to represent two sets

        Arrays.fill(colors, -1); // Initialize all vertices as uncolored

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1 && !dfs(graph, i, 0, colors)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int node, int color, int[] colors) {
        if (colors[node] != -1) {
            return colors[node] == color; // If the node is already colored, check if it's the same color as expected
        }

        colors[node] = color; // Assign color to the current node

        for (int neighbor : graph[node]) {
            if (!dfs(graph, neighbor, 1 - color, colors)) { // Recursively assign colors to neighbors
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { {1, 3}, {0, 2}, {1, 3}, {0, 2} };

        BipartiteGraph bipartiteGraph = new BipartiteGraph();
        boolean isBipartite = bipartiteGraph.isBipartite(graph);
        System.out.println("Is the graph bipartite? " + isBipartite);
    }
}
