import java.util.ArrayList;
import java.util.List;

public class Day98 {
    public static List<Integer> findIndices(String s, String pattern) {
        List<Integer> indices = new ArrayList<>();
        int n = s.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            if (s.substring(i, i + m).equals(pattern)) {
                indices.add(i + 1); 
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        String s1 = "abdchabd";
        String pattern1 = "abd";
        List<Integer> indices1 = findIndices(s1, pattern1);
        System.out.println("Output 1: " + indices1);

        String s2 = "aaaaaa";
        String pattern2 = "aa";
        List<Integer> indices2 = findIndices(s2, pattern2);
        System.out.println("Output 2: " + indices2);
    }
}
