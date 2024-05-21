import java.util.*;
public class Day29 {

    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclicUtil(i, visited, recursionStack, adj)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isCyclicUtil(int v, boolean[] visited, boolean[] recursionStack, List<List<Integer>> adj) {
        visited[v] = true;
        recursionStack[v] = true;

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, recursionStack, adj)) {
                    return true;
                }
            } else if (recursionStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        recursionStack[v] = false; 
        return false;
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);

        boolean hasCycle = hasCycle(V, adj);
        System.out.println("Does the graph have a cycle? " + hasCycle);
    }
}
