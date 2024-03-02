import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        backtrack(s, 0, currentPartition, result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentPartition.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentPartition, result);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        
        // Example 1
        String s1 = "aab";
        List<List<String>> result1 = solution.partition(s1);
        System.out.println("Example 1:");
        System.out.println(result1);
        
        // Example 2
        String s2 = "a";
        List<List<String>> result2 = solution.partition(s2);
        System.out.println("Example 2:");
        System.out.println(result2);
    }
}
