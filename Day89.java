import java.util.ArrayList;
import java.util.List;

public class Day89 {
    public static List<Integer> findIndices(String s, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int n = s.length();
        int m = pattern.length();

        long patternHash = calculateHash(pattern);
        long currentHash = calculateHash(s.substring(0, m));

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == currentHash && s.substring(i, i + m).equals(pattern)) {
                indices.add(i + 1); // Adjusting index to 1-based indexing
            }

            if (i < n - m) {
                currentHash = recalculateHash(s, currentHash, i, m);
            }
        }

        return indices;
    }

    private static long calculateHash(String s) {
        long hash = 0;
        int prime = 31;
        int p_power = 1;
        int mod = 1000000007;

        for (char c : s.toCharArray()) {
            hash = (hash + (c - 'a' + 1) * p_power) % mod;
            p_power = (p_power * prime) % mod;
        }

        return hash;
    }
    private static long recalculateHash(String s, long currentHash, int start, int length) {
        int prime = 31;
        int mod = 1000000007;
        long p_power = 1;

        currentHash = (currentHash - (s.charAt(start) - 'a' + 1) + mod) % mod;
        currentHash = (currentHash * inverse(prime, mod)) % mod;
        currentHash = (currentHash + (s.charAt(start + length) - 'a' + 1) * p_power) % mod;

        return currentHash;
    }
    private static long inverse(long a, long mod) {
        long result = 1;
        long b = mod - 2; // Since mod is prime, a^(mod-1) = 1 (Fermat's Little Theorem)

        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "abdchabd";
        String pattern = "abd";
        List<Integer> indices = findIndices(s, pattern);
        for (int index : indices) {
            System.out.print(index + " ");
        }
    }
}

