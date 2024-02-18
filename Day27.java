import java.util.*;

class Graph {
    private int vertices;
    private Map<Integer, List<Integer>> adjacencyList;

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

    // Method to find the shortest path using Breadth-First Search (BFS)
    public List<Integer> shortestPath(int startVertex, int endVertex) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, currentVertex);

                    if (neighbor == endVertex) {
                        // Reconstruct the path
                        List<Integer> path = new ArrayList<>();
                        int vertex = endVertex;
                        while (vertex != startVertex) {
                            path.add(vertex);
                            vertex = parentMap.get(vertex);
                        }
                        path.add(startVertex);
                        Collections.reverse(path);
                        return path;
                    }
                }
            }
        }

        return Collections.emptyList(); // No path found
    }
}

public class Day27 {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        int startVertex = 0;
        int endVertex = 4;

        List<Integer> shortestPath = graph.shortestPath(startVertex, endVertex);

        if (!shortestPath.isEmpty()) {
            System.out.println("Shortest path from " + startVertex + " to " + endVertex + ": " + shortestPath);
        } else {
            System.out.println("No path found from " + startVertex + " to " + endVertex);
        }
    }
}
