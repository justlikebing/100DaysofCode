import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day49 {

    public static List<List<Integer>> generatePowerSet(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(arr[i]);
                }
            }

            result.add(subset);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        int[] arr1 = {1, 2, 3};
        List<List<Integer>> result1 = generatePowerSet(arr1);
        printResult(result1);

        int[] arr2 = {5, 7, 8};
        List<List<Integer>> result2 = generatePowerSet(arr2);
        printResult(result2);
    }

    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> subset : result) {
            for (int num : subset) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
