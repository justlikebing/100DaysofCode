import java.util.HashMap;
import java.util.Map;

public class Day69 {
    public int countSubarrays(int[] A, int B) {
        int count = 0;
        int xor = 0;
        Map<Integer, Integer> prefixXOR = new HashMap<>();
        prefixXOR.put(0, 1);
        
        for (int num : A) {
            xor ^= num;
            int target = xor ^ B;
            count += prefixXOR.getOrDefault(target, 0);
            prefixXOR.put(xor, prefixXOR.getOrDefault(xor, 0) + 1);
        } 
        return count;
    }
    public static void main(String[] args) {
        SubarraysWithXOR obj = new SubarraysWithXOR();
        int[] A = {1, 2, 3, 2};
        int B = 2;
        System.out.println("Number of subarrays with XOR equal to " + B + ": " + obj.countSubarrays(A, B)); // Output: 3
    }
}
