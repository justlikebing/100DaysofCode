import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Day18 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        // Iterate through the array in a circular manner
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]) {
                stack.pop();
            }

            // The stack now contains elements greater than nums[i % n]
            result[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
            nextGreaterMap.put(i % n, result[i % n]);
            stack.push(i % n);
        }

        return result;
    }

    public static void main(String[] args) {
        Day18 nextGreaterElement = new Day18();

        // Example usage
        int[] nums = {4, 2, 10, 8, 1, 6};
        int[] result = nextGreaterElement.nextGreaterElements(nums);

        System.out.println("Next Greater Elements for the array: " + java.util.Arrays.toString(nums));
        System.out.println("Result: " + java.util.Arrays.toString(result));
    }
}
