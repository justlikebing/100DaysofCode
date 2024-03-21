import java.util.*;

public class Day58 {
    public static List<List<Integer>> findQuadruplets(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quadruplets;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1, 0, 1};
        int target1 = 5;
        System.out.println("Sample Input 1: " + findQuadruplets(nums1, target1).size());

        int[] nums2 = {2, 2, 2, 2, 1, 3};
        int target2 = 8;
        System.out.println("Sample Input 2: " + findQuadruplets(nums2, target2).size());

        int[] nums3 = {1, 1, 1, 0};
        int target3 = 4;
        System.out.println("Sample Input 3: " + findQuadruplets(nums3, target3).size());
    }
}
