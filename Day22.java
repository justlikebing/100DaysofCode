import java.util.ArrayList;
import java.util.List;

public class Day22 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Day22 subsets = new Day22();

        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets.subsets(nums);

        System.out.println("Subsets of " + java.util.Arrays.toString(nums) + ":");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
