class ListNode {
    int val;
    ListNode next;
    ListNode child;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
        this.child = null;
    }
}

public class Day57 {
    public ListNode flatten(ListNode head) {
        if (head == null) return null;
        
        ListNode current = head;
        while (current != null) {
            if (current.child != null) {
                ListNode nextNode = current.next;
                ListNode childList = flatten(current.child);
                current.child = null;
                current.next = childList;
                
                while (current.next != null) {
                    current = current.next;
                }
                
                current.next = nextNode;
                if (nextNode != null) {
                    nextNode = nextNode.next;
                }
            }
            current = current.next;
        }
        return head;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FlattenLinkedList solution = new FlattenLinkedList();

        // Create sample linked list
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(10);
        ListNode node7 = new ListNode(15);
        ListNode node8 = new ListNode(18);
        ListNode node9 = new ListNode(22);
        ListNode node10 = new ListNode(29);

        node1.child = node4;
        node4.next = node3;
        node3.next = node2;
        node2.child = node5;
        node5.next = node6;
        node6.next = node7;
        node7.child = node8;
        node8.next = node9;
        node9.next = node10;

        ListNode flattenedList = solution.flatten(node1);
        solution.printList(flattenedList);
    }
}
