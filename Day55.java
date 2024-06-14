import java.util.*;
public class Day55 {
    public static int longestSubarrayWithZeroSum(int[] nums) {
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxLength = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    maxLength = Math.max(maxLength, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 
        
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); 
            int[] nums = new int[N];
            
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            
            int result = longestSubarrayWithZeroSum(nums);
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}
