import java.util.Scanner;

public class Day95 {
    public static String nthTerm(int n) {
        if (n == 1) {
            return "1";
        }

        String currentTerm = "1";
        for (int i = 2; i <= n; i++) {
            currentTerm = nextTerm(currentTerm);
        }

        return currentTerm;
    }

    public static String nextTerm(String term) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char currentChar = term.charAt(0);

        for (int i = 1; i < term.length(); i++) {
            if (term.charAt(i) == currentChar) {
                count++;
            } else {
                result.append(count);
                result.append(currentChar);
                count = 1;
                currentChar = term.charAt(i);
            }
        }

        result.append(count);
        result.append(currentChar);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            System.out.println(nthTerm(N));
        }
        scanner.close();
    }
}

