package data_structures.linkedlists.medium;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList_143 {

    public static class ListNode {
      int val;
      ListNode next;

      ListNode(int val) { this.val = val; }
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        Deque<ListNode> deque = new LinkedList<>();
        ListNode current = head;
        while (current!=null) {
            deque.offerLast(current);
            current = current.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!deque.isEmpty()) {
            tail.next = deque.pollFirst();
            tail = tail.next;

            if (!deque.isEmpty()) {
                tail.next = deque.pollLast();
                tail = tail.next;
            }
        }
        tail.next = null;
        head = dummy.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Helper function to create a linked list from an array of values
    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test case 1: Reorder the list [1, 2, 3, 4]
        int[] values1 = {1, 2, 3, 4};
        ListNode head1 = createList(values1);
        System.out.println("Original list:");
        printList(head1);

        reorderList(head1);

        System.out.println("Reordered list:");
        printList(head1);

        // Test case 2: Reorder the list [1, 2, 3, 4, 5]
        int[] values2 = {1, 2, 3, 4, 5};
        ListNode head2 = createList(values2);
        System.out.println("\nOriginal list:");
        printList(head2);

        reorderList(head2);

        System.out.println("Reordered list:");
        printList(head2);
    }
}
