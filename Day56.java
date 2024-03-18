import java.util.*;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Day56 {
    
    public static ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        
        ListNode head = null;
        ListNode tail = null;
        
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            ListNode newNode = new ListNode(num);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        
        ListNode middle = findMiddle(head);
        
        while (middle != null) {
            System.out.print(middle.val + " ");
            middle = middle.next;
        }
        
        scanner.close();
    }
}
