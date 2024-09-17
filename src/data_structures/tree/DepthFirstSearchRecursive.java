package data_structures.tree;

public class DepthFirstSearchRecursive {

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
        System.out.print(node.data+" ");

        depthFirstSearch(node.left);
        depthFirstSearch(node.right);
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
