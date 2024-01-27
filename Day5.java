public class Day5{
    public static void main(String[] args){
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next; // Store the next node
                head.next = newHead; // Reverse the link
                newHead = head; // Move newHead to the current node
                head = next; // Move head to the next node
            }
            return newHead;
        }
    }
}