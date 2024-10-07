package data_structures.linkedlists.easy;

public class MiddleOfTheLinkedList_876 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int val) { this.val = val; }
  }
     ListNode head = null;

    /**
    Input: head = [1,2,3,4,5,6]
    Output: [4,5,6]
    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
     **/
    public void add(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public ListNode findMiddleNode() {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        MiddleOfTheLinkedList_876 middle = new MiddleOfTheLinkedList_876();
        middle.add(1);
        middle.add(2);
        middle.add(3);
        middle.add(4);
        middle.add(5);
        middle.add(6);

        ListNode middle1 = middle.findMiddleNode();
        if (middle1 != null) {
            System.out.print("Middle of LinkedList is: ");
            middle.printList(middle1);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
