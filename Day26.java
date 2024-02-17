import java.util.*;

// Graph class with adjacency list representation
class Graph {
    private int vertices;
    private Map<Integer, List<Integer>> adjacencyList;

    // Constructor to initialize the graph with a given number of vertices
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new LinkedList<>());
        }
    }

    // Method to add an edge between two vertices
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For undirected graph
    }

    // Depth-First Search (DFS) traversal
    public void dfsTraversal(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        System.out.println("DFS Traversal starting from vertex " + startVertex + ":");
        dfsHelper(startVertex, visited);
        System.out.println();
    }

    // Helper method for DFS traversal
    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int neighbor : adjacencyList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}

public class Day26 {
    public static void main(String[] args) {
        // Example usage:
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        // Perform DFS traversal starting from vertex 0
        graph.dfsTraversal(0);
    }
}
