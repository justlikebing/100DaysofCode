import java.util.ArrayList;
import java.util.List;

class StringPatternMatching {

    public static List<Integer> findOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        if (m > n) {
            return occurrences; 
        }

        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, m));

        if (patternHash == textHash && pattern.equals(text.substring(0, m))) {
            occurrences.add(1); // Pattern found at the beginning
        }

        // Precompute the value of R^(m-1) for rolling hash
        long power = 1;
        for (int i = 0; i < m - 1; i++) {
            power = (power * 256) % 101; // 101 is a prime number
        }

        for (int i = 1; i <= n - m; i++) {
            textHash = (textHash + 101 - (text.charAt(i - 1) * power) % 101) % 101; // Remove the leftmost character
            textHash = (textHash * 256 + text.charAt(i + m - 1)) % 101; // Add the next character

            if (patternHash == textHash && pattern.equals(text.substring(i, i + m))) {
                occurrences.add(i + 1); // Pattern found at position i+1
            }
        }

        return occurrences;
    }

    private static long calculateHash(String s) {
        long hash = 0;
        int prime = 101; // A prime number

        for (int i = 0; i < s.length(); i++) {
            hash = (hash * 256 + s.charAt(i)) % prime;
        }

        return hash;
    }

    public static void main(String[] args) {
        String text1 = "cxyzghxyzvjkxyz";
        String pattern1 = "xyz";
        List<Integer> occurrences1 = findOccurrences(text1, pattern1);
        System.out.println("Sample Output 1: " + occurrences1); // Output: [2, 7, 13]

        String text2 = "ababacabab";
        String pattern2 = "aba";
        List<Integer> occurrences2 = findOccurrences(text2, pattern2);
        System.out.println("Sample Output 2: " + occurrences2); // Output: [1, 3, 7]

        String text3 = "abcd";
        String pattern3 = "xy";
        List<Integer> occurrences3 = findOccurrences(text3, pattern3);
        System.out.println("Sample Output 3: " + occurrences3); // Output: [0]
    }
}
