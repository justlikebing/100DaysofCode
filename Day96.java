public class Day96 {
    public static int countPalindromicSubsequences(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1; // Single character is a palindrome
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        int l = i + 1;
                        int r = j - 1;

                        while (l <= r && s.charAt(i) != s.charAt(l)) {
                            l++;
                        }
                        while (l <= r && s.charAt(j) != s.charAt(r)) {
                            r--;
                        }

                        if (l > r) {
                            dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                        } else if (l == r) {
                            dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1] * 2 - dp[l + 1][r - 1];
                        }
                    } else {
                        dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                    }
                }
                dp[i][j] = (dp[i][j] < 0) ? dp[i][j] + mod : dp[i][j] % mod;
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "pqqr";
        System.out.println("Output: " + countPalindromicSubsequences(s));
    }
}
