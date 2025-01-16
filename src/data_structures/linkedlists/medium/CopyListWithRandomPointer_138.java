package data_structures.linkedlists.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> nodeMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (nodeMap.containsKey(head)) {
            return nodeMap.get(head);
        }
        Node copy = new Node(head.val);
        nodeMap.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = nodeMap.get(head.random);
        return copy;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        CopyListWithRandomPointer_138 solution = new CopyListWithRandomPointer_138();
        Node copiedListHead = solution.copyRandomList(node1);
        System.out.println("Original list:");
        printList(node1);

        System.out.println("\nCopied list:");
        printList(copiedListHead);
    }

    private static void printList(Node head) {
        Node current = head;
        while (current != null) {
            String randomVal = (current.random != null) ? String.valueOf(current.random.val) : "null";
            System.out.println("Node value: " + current.val + ", Random points to: " + randomVal);
            current = current.next;
        }
    }

}
