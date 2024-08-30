public class Day7 {
    public static void main(String[] args){
    }
    class solution{
        public ListNode removeNthEle(ListNode head, int n){
            ListNode start = new ListNode();
            start.next = head;
            ListNode fast = start;
            ListNode slow = start;

            for(int i = 1; i <= n ; i++){
                fast = fast.next;
            }
            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return start.next;

        }
    }
    
}
