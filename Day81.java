import java.util.*;

public class Day81 {
    public static String canColorGraph(int[][] adjMatrix, int m) {
        int v = adjMatrix.length;
        int[] color = new int[v];
        Arrays.fill(color, 0);
        
        // Function to check if it's safe to assign color 'c' to vertex 'vtx'
        boolean isSafe(int vtx, int c) {
            for (int i = 0; i < v; i++) {
                if (adjMatrix[vtx][i] == 1 && color[i] == c) {
                    return false;
                }
            }
            return true;
        }
        
        // Recursive function to color the graph
        boolean colorGraphUtil(int vtx) {
            if (vtx == v) {
                return true;
            }
            for (int c = 1; c <= m; c++) {
                if (isSafe(vtx, c)) {
                    color[vtx] = c;
                    if (colorGraphUtil(vtx + 1)) {
                        return true;
                    }
                    color[vtx] = 0;
                }
            }
            return false;
        }
        
        if (colorGraphUtil(0)) {
            return "YES";
        } else {
            return "NO";
        }
    }
    
    public static void main(String[] args) {
        int[][] adjMatrix = {
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
        };
        int m = 3;
        System.out.println(canColorGraph(adjMatrix, m));  // Output: YES
    }
}
