import java.util.*;

public class Day59 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int start = 0, end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            charIndexMap.put(currentChar, end);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input1 = "abcabcbb";
        System.out.println("Sample Input 1: " + lengthOfLongestSubstring(input1));

        String input2 = "aaaa";
        System.out.println("Sample Input 2: " + lengthOfLongestSubstring(input2));
    }
}
