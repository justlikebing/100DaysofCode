import java.util.HashMap;
import java.util.Map;

public class Day28 {

    private static Map<Integer, Integer> memoizationMap = new HashMap<>();

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (memoizationMap.containsKey(n)) {
            return memoizationMap.get(n);
        }

        int fibValue = fibonacci(n - 1) + fibonacci(n - 2);
        memoizationMap.put(n, fibValue);

        return fibValue;
    }

    public static void main(String[] args) {
        int n = 10; // Change n to the desired Fibonacci sequence index

        int result = fibonacci(n);

        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}
