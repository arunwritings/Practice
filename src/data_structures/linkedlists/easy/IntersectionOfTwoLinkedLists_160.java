package data_structures.linkedlists.easy;

public class IntersectionOfTwoLinkedLists_160 {

    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists_160 intersection = new IntersectionOfTwoLinkedLists_160();

        ListNode commonNode = new ListNode(8);
        commonNode.next = new ListNode(4);
        commonNode.next.next = new ListNode(5);

        ListNode listNodeA = new ListNode(4);
        listNodeA.next = new ListNode(1);
        listNodeA.next.next = commonNode;

        ListNode listNodeB = new ListNode(5);
        listNodeB.next = new ListNode(6);
        listNodeB.next.next = new ListNode(1);
        listNodeB.next.next.next = commonNode;

        ListNode result = intersection.getIntersectionNode(listNodeA, listNodeB);
        System.out.println(result != null ? "Intersection at node with value: " + result.val : "No intersection");
    }
}
