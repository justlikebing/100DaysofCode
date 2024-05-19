import java.util.Arrays;

public class Day11{
    private static int simpleHash(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);

        int hash = 0;
        for (char c : charArray) {
            hash += (int) c;
        }

        return hash;
    }

    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";

        int hash1 = simpleHash(str1);
        int hash2 = simpleHash(str2);
        System.out.println("Hash Code for \"" + str1 + "\": " + hash1);
        System.out.println("Hash Code for \"" + str2 + "\": " + hash2);
    }
}
