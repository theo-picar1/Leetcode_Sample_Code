package linked_lists;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        // Test 1: [1, 2, 3, 4, 5], 2
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEnd(head, 2);

        // Test 2: [1], 1
//        ListNode head = new ListNode(1);
//        print(removeNthFromEnd(head2, 1));
//
//        // Test 3: [1, 2], 2
//        ListNode head3 = new ListNode(1, new ListNode(2));
//        print(removeNthFromEnd(head3, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy, right = head;

        System.out.println("Right pointer needs to be " +n+ " steps ahead of left pointer...\n");

        // Make right go 'n' steps ahead
        while (n > 0) {
            right = right.next;
            n--;
        }

        System.out.println("Done! Now need to increment left pointer until right pointer is null...\n");

        // Then bring left pointer up until right pointer is null
        while (right != null) {
            right = right.next;
            left = left.next; // Will point to just before the node we need to remove
        }

        System.out.println("Left pointer is now pointing at node [" +left.val+ "]. The node before the node to be removed: [" +left.next.val+ "]");
        System.out.println("Making current node point to node after [" +left.next.val+ "], node [" +left.next.next.val+ "]\n");

        left.next = left.next.next; // Skip over node by letting left pointer point to node past node to remove

        System.out.println("Node has been successfully removed!");
        return dummy.next;
    }
}
