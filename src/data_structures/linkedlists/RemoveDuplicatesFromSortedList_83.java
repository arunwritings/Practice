package data_structures.linkedlists;

public class RemoveDuplicatesFromSortedList_83 {

    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        // Traverse the list
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the next node as it's a duplicate
                current.next = current.next.next;
            } else {
                // Move to the next node if no duplicate
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromSortedList_83 obj = new RemoveDuplicatesFromSortedList_83();
        ListNode newNode = obj.deleteDuplicates(head);
        while (newNode != null) {
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
    }
}
