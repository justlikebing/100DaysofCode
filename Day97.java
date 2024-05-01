public class Day97 {
    public static int minRepeats(String a, String b) {
        int repeat = 1;
        StringBuilder repeatedA = new StringBuilder(a);

        while (repeatedA.length() < b.length()) {
            repeatedA.append(a);
            repeat++;
        }

        if (repeatedA.toString().contains(b)) {
            return repeat;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        String a1 = "abcd";
        String b1 = "cdabcdab";
        System.out.println("Output 1: " + minRepeats(a1, b1));

        String a2 = "a";
        String b2 = "aa";
        System.out.println("Output 2: " + minRepeats(a2, b2));
    }
}

