package data_structures.linkedlists.medium;

public class RemoveNthNodeFromEndOfList_19 {

    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode firstPointer = dummyNode;
        ListNode secondPointer = dummyNode;

        for (int i=0;i<n;i++) {
            secondPointer = secondPointer.next;
        }
        while (secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        firstPointer.next = firstPointer.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList_19 removeNthNodeFromEndOfList19 = new RemoveNthNodeFromEndOfList_19();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(removeNthNodeFromEndOfList19.removeNthFromEnd(listNode,3));

    }
}
