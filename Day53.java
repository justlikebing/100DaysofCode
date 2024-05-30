import java.util.Scanner;
public class Day53 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        
        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt(); 
            int N = scanner.nextInt(); 
            
            System.out.println(uniquePaths(M, N));
        }
        scanner.close();
    }
}
