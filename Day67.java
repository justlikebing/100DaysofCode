public class Day67 {
    public static void main(String[] args) {
        String[] arr = {"coding", "codezen", "codingninja", "coders"};
        String longestCommonPrefix = longestCommonPrefix(arr);
        System.out.println("Longest Common Prefix: " + longestCommonPrefix);
    }

    public static String longestCommonPrefix(String[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
