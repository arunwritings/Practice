package data_structures.linkedlists.medium;

public class RotateList_61 {

    class ListNode {
          int val;
          ListNode next;
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     Given the head of a linked list, rotate the list to the right by k places.
     Input: head = [1,2,3,4,5], k = 2
     Output: [4,5,1,2,3]

     Input: head = [0,1,2], k = 4
     Output: [2,0,1]
     **/
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int length =1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        k = k%length;
        int newHead = length - k;
        ListNode newTail = tail;

        while (newHead-- > 0) {
            newTail = newTail.next;
        }
        head = newTail.next;
        newTail.next = null;
        return head;
    }

    public static void main(String[] args) {
        RotateList_61 rotateList = new RotateList_61();
        ListNode head = rotateList.new ListNode(1, rotateList.new ListNode(2, rotateList.new ListNode(3, rotateList.new ListNode(4,  rotateList.new ListNode(5)))));
        ListNode rotatedList = rotateList.rotateRight(head, 2);
        // Print rotated list for verification
        while (rotatedList != null) {
            System.out.print(rotatedList.val + " ");
            rotatedList = rotatedList.next;
        }
    }
}
