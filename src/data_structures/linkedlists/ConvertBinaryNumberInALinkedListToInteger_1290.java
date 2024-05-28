package data_structures.linkedlists;

public class ConvertBinaryNumberInALinkedListToInteger_1290 {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int getDecimalValue(ListNode head) {
        StringBuilder binaryNumbers = new StringBuilder();
        while (head != null) {
            binaryNumbers.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(binaryNumbers.toString(), 2);
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(1, null);
        ListNode node2 = new ListNode(0, node3);
        ListNode head = new ListNode(1, node2);
        int decimalValue = getDecimalValue(head);
        System.out.println("Decimal value: " + decimalValue);
    }
}
