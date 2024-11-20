package data_structures.linkedlists.medium;

public class OddEvenLinkedList_328 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
    }

    /**
     Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
     The first node is considered odd, and the second node is even, and so on.
     Note that the relative order inside both the even and odd groups should remain as it was in the input.
     You must solve the problem in O(1) extra space complexity and O(n) time complexity.

     Input: head = [2,1,3,5,6,4,7]
     Output: [2,3,6,7,1,5,4]
     **/
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = odd.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        OddEvenLinkedList_328 oddEvenLinkedList328 = new OddEvenLinkedList_328();
        ListNode result = oddEvenLinkedList328.oddEvenList(listNode);
        System.out.println(result);
    }
}
