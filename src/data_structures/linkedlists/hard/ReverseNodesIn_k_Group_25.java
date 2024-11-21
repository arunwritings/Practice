package data_structures.linkedlists.hard;

public class ReverseNodesIn_k_Group_25 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode predecessor = dummyNode, current = dummyNode;
        while (current.next != null) {
            for (int i=0;i<k && current!=null;i++) {
                current = current.next;
            }
            if (current == null) {
                return dummyNode.next;
            }
            ListNode temp = current.next;
            current.next = null;
            ListNode start = predecessor.next;
            predecessor.next = reverseList(start);
            start.next = temp;
            predecessor = start;
            current = predecessor;
        }
        return dummyNode.next;
    }

    private ListNode reverseList(ListNode start) {
        ListNode current = start, previous = null;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        ReverseNodesIn_k_Group_25 reverseNodesInKGroup25 = new ReverseNodesIn_k_Group_25();
        ListNode result= reverseNodesInKGroup25.reverseKGroup(listNode, 4);
        printList(result);
    }
}
