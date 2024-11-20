package data_structures.linkedlists.medium;

import java.util.Arrays;
import java.util.Collections;

public class SortList_148 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow.next;
        slow.next = null;
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(middle);
        return merge(leftHalf, rightHalf);
    }

    private static ListNode merge(ListNode leftHalf, ListNode rightHalf) {
        ListNode dummyNode = new ListNode();
        ListNode current = dummyNode;
        while (leftHalf != null && rightHalf != null) {
            if (leftHalf.val <= rightHalf.val) {
                current.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                current.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            current = current.next;
        }
        current.next = (leftHalf == null) ? rightHalf : leftHalf;
        return dummyNode.next;
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
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next = new ListNode(9);
        SortList_148 sortList148 = new SortList_148();
        ListNode result = sortList148.sortList(node);
        printList(result);
    }


}
