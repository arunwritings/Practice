package data_structures.linkedlists;

public class MergeTwoSortedLists_21 {

    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // Dummy node to start merging
        ListNode current = dummy; // Pointer to build the merged list

        // Traverse both lists
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1; // Connect current to the smaller node
                list1 = list1.next; // Move list1 pointer forward
            } else {
                current.next = list2; // Connect current to the smaller node
                list2 = list2.next; // Move list2 pointer forward
            }
            current = current.next; // Move current pointer forward
        }
        // Connect the remaining nodes of l1 or l2 (one of them will be non-null)
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next; // Return the merged list starting from the next of dummy
    }

    public static void main(String[] args) {
        MergeTwoSortedLists_21 mergeTwoSortedLists21 = new MergeTwoSortedLists_21();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        ListNode mergedList = mergeTwoSortedLists21.mergeTwoLists(l1, l2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }
}
