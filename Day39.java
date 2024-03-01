import java.util.*;

public class Day39 {
    
    static int findMaxXOR(int[] arr, int Xi, int Ai) {
        int max = -1;
        
        for (int num : arr) {
            if (num <= Ai) {
                max = Math.max(max, Xi ^ num);
            }
        }
        
        return max;
    }
    
    static int[] bitwiseXORQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int Xi = queries[i][0];
            int Ai = queries[i][1];
            
            result[i] = findMaxXOR(arr, Xi, Ai);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            
            int[][] queries = new int[M][2];
            for (int i = 0; i < M; i++) {
                queries[i][0] = scanner.nextInt();
                queries[i][1] = scanner.nextInt();
            }
            
            int[] result = bitwiseXORQueries(arr, queries);
            
            for (int res : result) {
                System.out.print(res + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
