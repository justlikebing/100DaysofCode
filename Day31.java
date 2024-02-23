import java.util.ArrayList;
import java.util.PriorityQueue;

public class Day31 {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int N = A.size();

        A.sort((a, b) -> b - a);
        B.sort((a, b) -> b - a);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        maxHeap.offer(new Pair(0, 0, A.get(0) + B.get(0)));

        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        ArrayList<Integer> result = new ArrayList<>();

        for (int count = 0; count < C; count++) {
            Pair current = maxHeap.poll();
            result.add(current.sum);

            if (current.i + 1 < N && !visited[current.i + 1][current.j]) {
                maxHeap.offer(new Pair(current.i + 1, current.j, A.get(current.i + 1) + B.get(current.j)));
                visited[current.i + 1][current.j] = true;
            }
            if (current.j + 1 < N && !visited[current.i][current.j + 1]) {
                maxHeap.offer(new Pair(current.i, current.j + 1, A.get(current.i) + B.get(current.j + 1)));
                visited[current.i][current.j + 1] = true;
            }
        }

        return result;
    }

    static class Pair {
        int i;
        int j;
        int sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}
