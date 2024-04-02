import java.util.*;

public class Day71 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;
        
        // Step 1: Find the candidates
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++;
        }
        if (count1 > nums.length / 3)
            result.add(candidate1);
        if (count2 > nums.length / 3)
            result.add(candidate2);
        
        return result;
    }
    
    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        
        int[] nums = {2, 2, 1, 3, 1, 1, 3, 1, 1};
        List<Integer> result = solution.majorityElement(nums);
        System.out.println(result);
    }
}
