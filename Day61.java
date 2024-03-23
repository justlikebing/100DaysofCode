import java.util.*;

public class Day61 {
    
    public static List<String> wordBreak(String S, Set<String> dictionary) {
        List<String> result = new ArrayList<>();
        wordBreakHelper(S, dictionary, 0, new ArrayList<>(), result);
        return result;
    }

    public static void wordBreakHelper(String S, Set<String> dictionary, int start, List<String> currentSentence, List<String> result) {
        int n = S.length();
        if (start == n) {
            result.add(String.join(" ", currentSentence));
            return;
        }

        for (int end = start + 1; end <= n; end++) {
            String word = S.substring(start, end);
            if (dictionary.contains(word)) {
                currentSentence.add(word);
                wordBreakHelper(S, dictionary, end, currentSentence, result);
                currentSentence.remove(currentSentence.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int T = 1;
        List<String> testCases = Arrays.asList(
            "godisnowherenowhere"
        );
        List<Set<String>> dictionaries = Arrays.asList(
            new HashSet<>(Arrays.asList("god", "is", "no", "now", "where", "here"))
        );

        for (int i = 0; i < T; i++) {
            String S = testCases.get(i);
            Set<String> dictionary = dictionaries.get(i);
            List<String> sentences = wordBreak(S, dictionary);
            if (sentences.isEmpty()) {
                System.out.println("No output to be printed");
            } else {
                for (String sentence : sentences) {
                    System.out.println(sentence);
                }
            }
        }
    }
}
