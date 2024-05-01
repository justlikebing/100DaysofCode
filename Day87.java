public class Day87 {
    public static String longestPrefixSuffix(String str) {
        int n = str.length();
        int[] lps = new int[n]; // lps[i] stores the length of the longest proper prefix which is also a suffix of str.substring(0, i+1)

        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int longestLength = lps[n - 1];
        if (longestLength == 0) {
            return "";
        } else {
            return str.substring(0, longestLength);
        }
    }

    public static void main(String[] args) {
        String str1 = "ababcdabab";
        System.out.println("Output 1: " + longestPrefixSuffix(str1));

        String str2 = "aaaaabaa";
        System.out.println("Output 2: " + longestPrefixSuffix(str2));

        String str3 = "aab";
        System.out.println("Output 3: " + longestPrefixSuffix(str3));
    }
}

