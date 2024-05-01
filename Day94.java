public class Day94 {
    public static int indexOf(String text, String pat) {
        int n = text.length();
        int m = pat.length();

        if (m == 0) return 0; // Empty pattern matches at index 0

        // Build the prefix table for the pattern
        int[] prefix = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
                j = prefix[j - 1];
            }
            if (pat.charAt(i) == pat.charAt(j)) {
                prefix[i] = ++j;
            }
        }

        j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pat.charAt(j)) {
                j = prefix[j - 1];
            }
            if (text.charAt(i) == pat.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }

        return -1; // Pattern not found in text
    }

    public static void main(String[] args) {
        String text1 = "abcdecd";
        String pat1 = "cd";
        System.out.println("Output 1: " + indexOf(text1, pat1));

        String text2 = "codingninjas";
        String pat2 = "ninja";
        System.out.println("Output 2: " + indexOf(text2, pat2));

        String text3 = "abcde";
        String pat3 = "xyz";
        System.out.println("Output 3: " + indexOf(text3, pat3));
    }
}
