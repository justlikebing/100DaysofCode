public class Day50 {
    public static void main(String[] args) {
        int[] logs = { /* Your array of logs */ };
        int axes = /* Number of axes */;
        int logCuttingStandCapacity = /* Capacity of log cutting stand */;

        int result = findMinimumMoves(logs, axes, logCuttingStandCapacity);
        System.out.println("Minimum moves to determine the limit: " + result);
    }

    private static int findMinimumMoves(int[] logs, int axes, int logCuttingStandCapacity) {
        int left = 1;
        int right = logCuttingStandCapacity;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCutLogs(logs, axes, logCuttingStandCapacity, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canCutLogs(int[] logs, int axes, int logCuttingStandCapacity, int mid) {
        int moves = 0;

        for (int i = 0; i < logs.length; ) {
            int currentLogs = 0;

            while (i < logs.length && currentLogs + logs[i] <= mid) {
                currentLogs += logs[i];
                i++;
            }

            moves++;
            if (moves > axes) {
                return false; // Axe is broken, cannot use it again
            }
        }

        return true;
    }
}
