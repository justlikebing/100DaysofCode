import java.util.Arrays;
public class Day63 {
    public static int[] getMaxProfitJobs(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2])); 
        int maxDeadline = 0;
        for (int[] job : jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]); 
        }
        boolean[] slots = new boolean[maxDeadline]; // Create an array to track available slots
        int totalProfit = 0;
        int count = 0;
        for (int[] job : jobs) {
            for (int j = Math.min(maxDeadline - 1, job[1] - 1); j >= 0; j--) {
                if (!slots[j]) { 
                    slots[j] = true; // Mark the slot as filled
                    totalProfit += job[2]; // Add the profit of the completed job
                    count++; // Increment the count of completed jobs
                    break;
                }
            }
        }
        return new int[]{count, totalProfit};
    }
    public static void main(String[] args) {
        int[][] jobs1 = {{1, 2, 30}, {2, 2, 40}, {3, 1, 10}, {4, 1, 10}};
        int[] result1 = getMaxProfitJobs(jobs1);
        System.out.println(Arrays.toString(result1)); // Output: [2, 70]

        int[][] jobs2 = {{1, 1, 40}, {2, 1, 50}, {3, 1, 60}};
        int[] result2 = getMaxProfitJobs(jobs2);
        System.out.println(Arrays.toString(result2)); // Output: [1, 60]
    }
}
