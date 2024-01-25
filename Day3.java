public class Day3 {
    public static void main(String[] args){

    }
    class solution{
        public int findDuplicate(int[] nums){
            int slow = nums[0];
            int fast = nums[0];
            do{
                slow = nums[fast];
                fast = nums[nums[fast]];
            }
            while(slow != fast);
            fast = nums[0];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];

            }
            return slow;

        }

    }
    
}
