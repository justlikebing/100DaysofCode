import java.util.Scanner;

public class Day47 {

    public static String longestCommonPrefix(String[] arr) {
        if (arr.length == 0) {
            return "";
        }

        String prefix = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int j = 0;
            while (j < prefix.length() && j < arr[i].length() && prefix.charAt(j) == arr[i].charAt(j)) {
                j++;
            }

            prefix = prefix.substring(0, j);

            if (prefix.equals("")) {
                break;
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String[] arr = new String[n];

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.next();
            }

            String result = longestCommonPrefix(arr);
            System.out.println(result);
        }

        scanner.close();
    }
}
