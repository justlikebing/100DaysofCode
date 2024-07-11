class Celebrity {
    boolean knows(int A, int B) {
        return true; 
    }
    int findCelebrity(int N) {
        int candidate = 0;

        for (int i = 1; i < N; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < N; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1; // No celebrity found
            }
        }

        return candidate; // Found the celebrity
    }

    public static void main(String[] args) {
        Celebrity celebrityFinder = new Celebrity();

        int N1 = 2;
        int result1 = celebrityFinder.findCelebrity(N1);
        System.out.println("Example 1: " + result1);

        int N2 = 2;
        int result2 = celebrityFinder.findCelebrity(N2);
        System.out.println("Example 2: " + result2);
    }
}
