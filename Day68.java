public class Day68 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = maxProd;
            maxProd = Math.max(Math.max(maxProd * nums[i], minProd * nums[i]), nums[i]);
            minProd = Math.min(Math.min(temp * nums[i], minProd * nums[i]), nums[i]);
            result = Math.max(result, maxProd);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();
        int[] arr = {-3, 4, 5};
        System.out.println("Maximum product of contiguous subarray: " + obj.maxProduct(arr)); // Output: 20
    }
}

