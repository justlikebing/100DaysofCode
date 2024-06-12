import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
class Pair implements Comparable<Pair> {
    int vertex;
    int distance;
    public Pair(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.distance, other.distance);
    }
}

public class Day46 {

    public static List<Integer> shortestPath(int V, List<List<int[]>> adj, int S) {
        List<Integer> distances = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        // Initialize distances with infinity and the source vertex with 0
        Arrays.fill(distances.toArray(), Integer.MAX_VALUE);
        distances.set(S, 0);
        minHeap.offer(new Pair(S, 0));

        while (!minHeap.isEmpty()) {
            Pair current = minHeap.poll();

            for (int[] neighbor : adj.get(current.vertex)) {
                int nextVertex = neighbor[0];
                int edgeWeight = neighbor[1];

                int newDistance = current.distance + edgeWeight;

                if (newDistance < distances.get(nextVertex)) {
                    distances.set(nextVertex, newDistance);
                    minHeap.offer(new Pair(nextVertex, newDistance));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int V = 2;
        List<List<int[]>> adj = new ArrayList<>();
        adj.add(Arrays.asList(new int[]{1, 9}));
        adj.add(Arrays.asList(new int[]{0, 9}));
        int S = 0;

        List<Integer> result = shortestPath(V, adj, S);
        System.out.println(result); // Output: [0, 9]
    }
}
