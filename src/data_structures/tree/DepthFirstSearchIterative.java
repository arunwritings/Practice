package data_structures.tree;

import java.util.Stack;

public class DepthFirstSearchIterative {

    static class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = right = null;
        }
    }
    static void depthFirstSearch(Node node) {
        if (node == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            Node root = stack.pop();
            System.out.print(root.data+" ");

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        depthFirstSearch(root);
    }
}
