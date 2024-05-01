import java.util.ArrayList;
import java.util.List;

public class Day99 {
    public static List<Integer> findOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        int[] prefix = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = prefix[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                prefix[i] = ++j;
            }
        }

        j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = prefix[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == m) {
                occurrences.add(i - m + 2);
                j = prefix[j - 1];
            }
        }
        return occurrences;
    }

    public static void main(String[] args) {
        String text = "cxyzghxyzvjkxyz";
        String pattern = "xyz";
        List<Integer> occurrences = findOccurrences(text, pattern);
        System.out.println("Occurrences = " + occurrences);
    }
}
