import java.util.ArrayList;
import java.util.List;

public class Day62 {

    public static List<String> findPaths(int[][] maze) {
        List<String> paths = new ArrayList<>();
        int N = maze.length;
        boolean[][] visited = new boolean[N][N];
        findPathsHelper(maze, 0, 0, visited, "", paths);
        return paths;
    }

    private static void findPathsHelper(int[][] maze, int row, int col, boolean[][] visited, String path, List<String> paths) {
        int N = maze.length;
        if (row < 0 || row >= N || col < 0 || col >= N || maze[row][col] == 0 || visited[row][col]) {
            return;
        }

        if (row == N - 1 && col == N - 1) {
            paths.add(path);
            return;
        }

        visited[row][col] = true;

        findPathsHelper(maze, row + 1, col, visited, path + "D", paths);
        findPathsHelper(maze, row - 1, col, visited, path + "U", paths);
        findPathsHelper(maze, row, col + 1, visited, path + "R", paths);
        findPathsHelper(maze, row, col - 1, visited, path + "L", paths);

        visited[row][col] = false;
    }

    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        List<String> paths = findPaths(maze);
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
